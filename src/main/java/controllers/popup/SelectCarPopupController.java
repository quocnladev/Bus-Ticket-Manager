package controllers.popup;

import dao.ListBusDao;
import models.ListBus;
import views.popup.SelectCarPopupView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectCarPopupController {

    ListBusDao listBusDao = new ListBusDao();
    JFrame previousView;

    public interface Callback {

        public abstract void run(ListBus listBus);
    }

    public void select(SelectCarPopupView view, Callback callback) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        try {
            view.renderCar(listBusDao.getAll());
        } catch (SQLException e) {
            view.showError(e);
        }
        view.getBtnOK().addActionListener(evt -> {
            ListBus c = view.getListCar().getSelectedValue();
            if (c == null) {
                view.showError("Bạn chưa chọn xe.");
                return;
            }
            callback.run(c);
            view.dispose();
        });
        view.getBtnSearch().addActionListener(evt -> {
            String txtSearch = view.getTxtNhaxe().getText();
//            String txtSearch1 = view.getTxtRoute().getText();
            try {
                view.renderCar(listBusDao.searchByKey("name", txtSearch));
//                view.renderCar(listBusDao.searchByKey("name", txtSearch1));
            } catch (Exception e) {
                view.showError(e);
            }
        });
        view.getBtnCancel().addActionListener(evt -> {
            view.dispose();
        });
    }
}
