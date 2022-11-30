package controllers.popup;

import dao.DriverDao;
import models.Driver;
import views.popup.SelectDriverPopupView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectDriverPopupController {

    DriverDao driverDao = new DriverDao();
    JFrame previousView;

    public interface Callback {

        public abstract void run(Driver driver);
    }

    public void select(SelectDriverPopupView view, Callback callback) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        try {
            view.renderDriver(driverDao.getAll());
        } catch (SQLException e) {
            view.showError(e);
        }
        view.getBtnOK().addActionListener(evt -> {
            Driver c = view.getListDriver().getSelectedValue();
            if (c == null) {
                view.showError("Bạn chưa chọn tài xế.");
                return;
            }
            callback.run(c);
            view.dispose();
        });
        view.getBtnSearch().addActionListener(evt -> {
            String txtSearch = view.getTxtDriverName().getText();
            try {
                view.renderDriver(driverDao.searchByKey("name", txtSearch));
            } catch (Exception e) {
                view.showError(e);
            }
        });
        view.getBtnCancel().addActionListener(evt -> {
            view.dispose();
        });
    }
}
