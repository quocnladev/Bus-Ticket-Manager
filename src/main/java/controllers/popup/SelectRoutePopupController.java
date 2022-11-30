package controllers.popup;

import dao.RouteDao;
import models.Route;
import views.popup.SelectRoutePopupView;

import javax.swing.*;
import java.sql.SQLException;

public class SelectRoutePopupController {

    RouteDao routeDao = new RouteDao();
    JFrame previousView;

    public interface Callback {

        public abstract void run(Route route);
    }

    public void select(SelectRoutePopupView view, Callback callback) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        try {
            view.renderRoute(routeDao.getAll());
        } catch (SQLException e) {
            view.showError(e);
        }
        view.getBtnOK().addActionListener(evt -> {
            Route route = view.getListRoute().getSelectedValue();
            if (route == null) {
                view.showError("Bạn chưa chọn tuyến đường.");
                return;
            }
            callback.run(route);
            view.dispose();
        });
        view.getBtnSearch().addActionListener(evt -> {
            String txtSearch = view.getTxtDepart().getText();
            String txtSearch1 = view.getTxtDestination().getText();
            try {
                view.renderRoute(routeDao.searchByKey("name", txtSearch));
                view.renderRoute(routeDao.searchByKey("name", txtSearch1));
            } catch (Exception e) {
                view.showError(e);
            }
        });
        view.getBtnCancel().addActionListener(evt -> {
            view.dispose();
        });
    }
}
