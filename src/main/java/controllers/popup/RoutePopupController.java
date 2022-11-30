package controllers.popup;

import dao.RouteDao;
import models.Route;
import views.popup.RoutePopupView;

import javax.swing.*;

public class RoutePopupController {

    RouteDao routeDao = new RouteDao();
    JFrame previousView;

    public void add(RoutePopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getBtnOK().addActionListener(evt -> {
            try {
                addRoute(view);
                view.dispose();
                view.showMessage("Thêm tuyến đường thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void edit(RoutePopupView view, Route route, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getLbTitle().setText("Sửa tuyến đường - " + route.getId());
        view.getTxtDepart().setText(route.getDepart());
        view.getTxtDestination().setText(route.getDestination());
        view.getTxtLength().setText(route.getLength());

        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editRoute(view, route);
                view.dispose();
                view.showMessage("Sửa thông tin tuyến đường thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addRoute(RoutePopupView view) throws Exception {
        String depart = view.getTxtDepart().getText(),
                destination = view.getTxtDestination().getText(),
                length = view.getTxtLength().getText();

        Route r = new Route();

        r.setDepart(depart);
        r.setDestination(destination);
        r.setLength(length);

        routeDao.save(r);
        return;
    }

    public boolean editRoute(RoutePopupView view, Route r) throws Exception {
        String depart = view.getTxtDepart().getText(),
                destination = view.getTxtDestination().getText(),
                length = view.getTxtLength().getText();

        r.setDepart(depart);
        r.setDestination(destination);
        r.setLength(length);

        routeDao.update(r);
        return true;
    }
}
