package controllers.admin;

import controllers.ManagerController;
import controllers.popup.ListBusPopupController;
import dao.ListBusDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.ListBus;
import views.popup.ListBusPopupView;

public class ListBusManagerController extends ManagerController {

    ListBusDao listBusDao = new ListBusDao();
    ListBusPopupController popupController = new ListBusPopupController();

    public ListBusManagerController() {
        super();
    }

    @Override
    public void actionAdd()  {
        popupController.add(new ListBusPopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn xe cần chinh sua");
            } else {
                ListBus listBus = listBusDao.get(selectedId);
                if (listBus == null) {
                    throw new Exception("Xe bạn chọn không hợp lệ");
                }
                popupController.edit(new ListBusPopupView(), listBus, this::updateData, view::showError);
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                listBusDao.deleteById(selectedIds[i]);
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<ListBus> listBuses = listBusDao.getAll();
            view.setTableData(listBuses);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<ListBus> listBuses = listBusDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(listBuses);
        } catch (SQLException ex) {
            Logger.getLogger(ListBusManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
