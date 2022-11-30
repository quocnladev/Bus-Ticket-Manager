package controllers.admin;

import controllers.ManagerController;
import controllers.popup.RoutePopupController;
import dao.RouteDao;
import models.Route;
import views.popup.RoutePopupView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;

public class RouteManagerController extends ManagerController {

    RouteDao routeDao = new RouteDao();
    RoutePopupController popupController = new RoutePopupController();

    public RouteManagerController() {
        super();
    }

    @Override
    public void actionAdd() {
        popupController.add(new RoutePopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn tuyến đường cần chinh sua");
            } else {
                Route route = routeDao.get(selectedId);
                if (route == null) {
                    throw new Exception("tuyến đường bạn chọn không hợp lệ");
                }
                popupController.edit(new RoutePopupView(), route, this::updateData, view::showError);
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa tuyến đường?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                routeDao.deleteById(selectedIds[i]);
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Route> routes = routeDao.getAll();
            view.setTableData(routes);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Route> routes = routeDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(routes);
        } catch (SQLException ex) {
            Logger.getLogger(RouteManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
