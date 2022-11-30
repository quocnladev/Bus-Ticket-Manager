package controllers.admin;

import controllers.ManagerController;
import controllers.popup.DriverPopupController;
import dao.DriverDao;
import models.Driver;
import views.popup.DriverPopupView;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;

public class DriverManagerController extends ManagerController {

    DriverDao driverDao = new DriverDao();
    DriverPopupController popupController = new DriverPopupController();
    DriverPopupController driverPopupController = new DriverPopupController();

    public DriverManagerController() {
        super();
    }

    @Override
    public void actionAdd() {
        driverPopupController.add(new DriverPopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa?", "Xóa tài xế", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                int id = selectedIds[i];
                driverDao.deleteById(id);
                updateData();
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn tài xế cần chỉnh sửa");
            } else {
                Driver c = driverDao.get(selectedId);
                if (c == null) {
                    throw new Exception("Tài xế bạn chọn không hợp lệ");
                }
                popupController.edit(new DriverPopupView(), c, this::updateData, view::showError);
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Driver> drivers = driverDao.getAll();
            view.setTableData(drivers);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Driver> drivers = driverDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(drivers);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
