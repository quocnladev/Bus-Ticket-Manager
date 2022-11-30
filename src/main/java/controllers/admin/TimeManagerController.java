package controllers.admin;

import controllers.ManagerController;

import controllers.popup.TimePopupController;
import dao.TimeDao;
import models.Time;
import views.popup.TimePopupView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;

public class TimeManagerController extends ManagerController {

    TimeDao timeDao = new TimeDao();
    TimePopupController popupController = new TimePopupController();

    public TimeManagerController() {
        super();
    }

    @Override
    public void actionAdd() {
        popupController.add(new TimePopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn thời gian cần chinh sua");
            } else {
                Time time = timeDao.get(selectedId);
                if (time == null) {
                    throw new Exception("Thời gian bạn chọn không hợp lệ");
                }
                popupController.edit(new TimePopupView(), time, this::updateData, view::showError);
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
                timeDao.deleteById(selectedIds[i]);
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Time> times = timeDao.getAll();
            view.setTableData(times);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Time> times = timeDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(times);
        } catch (SQLException ex) {
            Logger.getLogger(TimeManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
