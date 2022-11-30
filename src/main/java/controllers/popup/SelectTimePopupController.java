package controllers.popup;

import dao.TimeDao;
import models.Time;
import views.popup.SelectTimePopupView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectTimePopupController {

    TimeDao timeDao = new TimeDao();
    JFrame previousView;

    public interface Callback {

        public abstract void run(Time time);
    }

    public void select(SelectTimePopupView view, Callback callback) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        try {
            view.renderTime(timeDao.getAll());
        } catch (SQLException e) {
            view.showError(e);
        }
        view.getBtnOK().addActionListener(evt -> {
            Time time = view.getListTime().getSelectedValue();
            if (time == null) {
                view.showError("Bạn chưa chọn thời gian.");
                return;
            }
            callback.run(time);
            view.dispose();
        });
        view.getBtnSearch().addActionListener(evt -> {
            String txtSearch = view.getTxtTime().getText();
            try {
                view.renderTime(timeDao.searchByKey("name", txtSearch));
            } catch (Exception e) {
                view.showError(e);
            }
        });
        view.getBtnCancel().addActionListener(evt -> {
            view.dispose();
        });
    }
}
