package controllers.admin;

import controllers.ManagerController;
import controllers.popup.BookTicketPopupController;
import dao.BookTicketDao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import main.SessionManager;
import models.Employee;
import models.BookTicket;

import utils.EmployeePermission;

import views.admin.EmployeeManagerView;
import views.popup.EditOrderPopupView;
import views.popup.AddOrderPopupView;

public class BookTicketManagerController extends ManagerController {

    BookTicketDao bookTicketDao = new BookTicketDao();

    BookTicketPopupController popupController = new BookTicketPopupController();

    Employee session = SessionManager.getSession().getEmployee();

    public BookTicketManagerController() {
        super();
    }

    public void setView(EmployeeManagerView view) {
        super.setView(view);
    }

    @Override
    public void actionAdd() {
     popupController.add(new AddOrderPopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn hóa đơn cần edit");
            }
            BookTicket order = bookTicketDao.get(selectedId);
            if (order == null) {
                throw new Exception("Hóa đơn bạn chọn không hợp lệ");
            }

            popupController.edit(new EditOrderPopupView(), order, this::updateData, view::showError);

        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Không thể khôi phục\nXác nhận xóa hàng loạt?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                int id = selectedIds[i];
                BookTicket o = bookTicketDao.get(id);

                bookTicketDao.deleteById(id); // Xóa order
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            Employee employee = SessionManager.getSession().getEmployee();
            ArrayList<BookTicket> orders;
            if (employee.getPermission() == EmployeePermission.MANAGER) {
                orders = bookTicketDao.getAll();
            } else {
                orders = bookTicketDao.getAll(employee.getId());
            }
            view.setTableData(orders);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            Employee employee = SessionManager.getSession().getEmployee();
            ArrayList<BookTicket> tickets;
            String searchField = view.getCboSearchField().getSelectedItem().toString(), txtSearch = view.getTxtSearch().getText();
            if (employee.getPermission() == EmployeePermission.MANAGER) {
                tickets = bookTicketDao.searchByKey(searchField, txtSearch);
            } else {
                tickets = bookTicketDao.searchByKey(employee.getId(), searchField, txtSearch);
            }
            view.setTableData(tickets);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
