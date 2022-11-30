package controllers;

import controllers.admin.*;
import controllers.employee.InformationController;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SessionManager;
import models.Employee;
import utils.IconManager;

import views.EmployeeDashboardView;
import views.LoginView;
import views.admin.*;
import views.employee.InformationView;

public class EmployeeDashboardController {

    private EmployeeDashboardView view;
    ManagerController listBusManagerController = new ListBusManagerController(),
            routeManagerController = new RouteManagerController(),
            timeManagerController = new TimeManagerController(),
            bookTicketManagerController = new BookTicketManagerController(),
            customerManagerController = new CustomerManagerController();
    InformationController informationController = new InformationController();
    ManagerPaneView listBusManagerView = new ListBusManagerView(),
            routeManagerView = new RouteManagerView(),
    timeManagerView = new TimeManagerView(),
            bookTicketManagerView = new BookTicketManagerView(),
            customerManagerView = new CustomerManagerView();
    HomeView homeView = new HomeView();
    AboutView aboutView = new AboutView();
    InformationView informationView = new InformationView();

    SideBarController sideBarController = new SideBarController();
    JPanel[] cards = {homeView, listBusManagerView, routeManagerView, timeManagerView, bookTicketManagerView,
            customerManagerView,
         aboutView, informationView};

    public EmployeeDashboardController(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
        view.setVisible(true);
        initMenu();
        addEvent();
        Employee session = SessionManager.getSession().getEmployee();
        if (session != null) {
            view.getLbName().setText(session.getName());
        }
        view.setCards(cards);
        view.setPanel(homeView);
    }

    public EmployeeDashboardView getView() {
        return view;
    }

    public void setView(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
    }

    private void initMenu() {
        IconManager im = new IconManager();

        MenuItem menuKH = new MenuItem("QLKH", im.getIcon("technical_support_25px.png"), "Quản lý khách hàng");
        MenuItem menuQLDS = new MenuItem("QLDS", im.getIcon("cardboard_box_25px.png"), "Quản lý ds xe");
        MenuItem menuQLDV = new MenuItem("QLDDV", im.getIcon("shopping_cart_25px.png"), "Quản lý đặt vé");
        MenuItem menuTL = new MenuItem("TL", im.getIcon("settings_25px.png"), "Thiết lập");

        menuQLDS.addSubMenu(new MenuItem("QLDSXe", null, "Quản lý ds xe"));
        menuQLDS.addSubMenu(new MenuItem("QLDRoute", null, "Quản lý tuyến đường"));
        menuQLDS.addSubMenu(new MenuItem("QLDTime", null, "Quản lý thời gian"));


        menuTL.addSubMenu(new MenuItem("TTCN", im.getIcon("about_25px.png"), "Thông tin cá nhân"));
        menuTL.addSubMenu(new MenuItem("TLGD", im.getIcon("contrast_25px.png"), "Giao diện"));
        menuTL.addSubMenu(new MenuItem("TT", im.getIcon("help_25px.png"), "About us"));

        sideBarController.addMenu( menuKH, menuQLDS, menuQLDV, menuTL);
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    private void addEvent() {
        view.getBtnLogout().addActionListener(evt -> {
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn đăng xuất?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            try {
                SessionManager.update();// Đẵng xuất
            } catch (SQLException ex) {
                view.showError(ex);
            }
            view.dispose();
            new LoginController(new LoginView());
        });
    }

    public void onMenuChange(MenuItem item) {
        switch (item.getId()) {

            case "QLDDV"://Đặt vé
                view.setPanel(bookTicketManagerView);
                bookTicketManagerController.setView(bookTicketManagerView);
                bookTicketManagerController.updateData();
                break;

            case "QLKH"://Quản lý khách hàng
                view.setPanel(customerManagerView);
                customerManagerController.setView(customerManagerView);
                customerManagerController.updateData();
                break;

            case "QLDSXe"://Quản lý ds xe
                view.setPanel(listBusManagerView);
                listBusManagerController.setView(listBusManagerView);
                listBusManagerController.updateData();
                break;
            case "QLDRoute"://Quản lý tuyến đường
                view.setPanel(routeManagerView);
                routeManagerController.setView(routeManagerView);
                routeManagerController.updateData();
                break;
            case "QLDTime"://Quản lý thời gian
                view.setPanel(timeManagerView);
                timeManagerController.setView(timeManagerView);
                timeManagerController.updateData();
                break;


            case "QLHH":break;
            case "QLDH":break;
            case "TL":break;


            case "TT"://Thông tin
                view.setPanel(aboutView);
                break;
            case "TTCN": // Thống tin cá nhân
                view.setPanel(informationView);
                informationController.setView(informationView);
                break;
            default:
                view.setPanel(homeView);
                break;
        }
    }
}
