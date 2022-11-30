package controllers;

import controllers.admin.*;
import controllers.employee.InformationController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SessionManager;
import models.Employee;
import utils.IconManager;

import views.AdminDashboardView;
import views.LoginView;
import views.admin.AboutView;
import views.admin.CustomerManagerView;
import views.admin.DriverManagerView;

import views.admin.EmployeeManagerView;
import views.admin.ListBusManagerView;
import views.admin.RouteManagerView;
import views.admin.TimeManagerView;

import views.admin.HomeView;
import views.admin.ManagerPaneView;
import views.admin.MenuItem;
import views.admin.BookTicketManagerView;
import views.admin.StatisticalEmployeeView;
import views.admin.StatisticalIncomeView;
import views.admin.StatisticalView;

import views.employee.InformationView;

public class AdminDashboardController {

    private AdminDashboardView view;
    ManagerController employeeManagerController = new EmployeeManagerController(), // Controller
            listBusManagerController = new ListBusManagerController(),
            routeManagerController = new RouteManagerController(),
            timeManagerController = new TimeManagerController(),
            bookTicketManagerController = new BookTicketManagerController(),
            customerManagerController = new CustomerManagerController(),
            driverManagerController = new DriverManagerController();
    StatisticalController statisticalController = new StatisticalController();
    StatisticalIncomeController statisticalIncomeController = new StatisticalIncomeController();
    StatisticalEmployeeController statisticalEmployeeController = new StatisticalEmployeeController();
    InformationController informationController = new InformationController();

    HomeView homeView = new HomeView();
    ManagerPaneView employeeManagerView = new EmployeeManagerView(), // View
            listBusManagerView = new ListBusManagerView(),
            routeManagerView = new RouteManagerView(),
            timeManagerView = new TimeManagerView(),
            bookTicketManagerView = new BookTicketManagerView(),
            customerManagerView = new CustomerManagerView(),
            driverManagerView = new DriverManagerView();
    StatisticalView statisticalView = new StatisticalView();
    StatisticalIncomeView statisticalIncomeView = new StatisticalIncomeView();
    StatisticalEmployeeView statisticalEmployeeView = new StatisticalEmployeeView();
    AboutView aboutView = new AboutView();
    InformationView informationView = new InformationView();
    JPanel[] cards = {
        homeView, employeeManagerView, customerManagerView, driverManagerView,
            listBusManagerView, routeManagerView, timeManagerView, bookTicketManagerView,
        statisticalView, statisticalIncomeView, statisticalEmployeeView,
        aboutView, informationView
    };

    SideBarController sideBarController = new SideBarController();

    public AdminDashboardController(AdminDashboardView view) {
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

    public AdminDashboardView getView() {
        return view;
    }

    public void setView(AdminDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
    }

    private void initMenu() {
        IconManager im = new IconManager();
        MenuItem menuQLNV = new MenuItem("QLNV", im.getIcon("user_groups_25px.png"), "Quản lý nhân viên");
        MenuItem menuQLNS = new MenuItem("QLNS", im.getIcon("user_groups_25px.png"), "Quản lý nhân sự");
        MenuItem menuQLDS = new MenuItem("QLDS", im.getIcon("cardboard_box_25px.png"), "Quản lý ds xe");
        MenuItem menuQLDV = new MenuItem("QLDDV", im.getIcon("shopping_cart_25px.png"), "Quản lý đặt vé");
        MenuItem menuTK = new MenuItem("TK", im.getIcon("increase_25px.png"), "Thống kê");
        MenuItem menuTL = new MenuItem("TL", im.getIcon("settings_25px.png"), "Thiết lập");

        menuQLDS.addSubMenu(new MenuItem("QLDSXe", null, "Quản lý ds xe"));
        menuQLDS.addSubMenu(new MenuItem("QLDRoute", null, "Quản lý tuyến đường"));
        menuQLDS.addSubMenu(new MenuItem("QLDTime", null, "Quản lý thời gian"));

        menuQLNS.addSubMenu(new MenuItem("QLKH", im.getIcon("technical_support_25px.png"), "Quản lý khách hàng"));
        menuQLNS.addSubMenu(new MenuItem("QLTX", im.getIcon("technical_support_25px.png"), "Quản lý tài xế"));


        menuTK.addSubMenu(new MenuItem("TKNV", im.getIcon("user_25px.png"), "Thống kê nhân viên"));
        menuTK.addSubMenu(new MenuItem("TKDT", null, "Thống kê doanh thu"));

        menuTL.addSubMenu(new MenuItem("TTCN", im.getIcon("about_25px.png"), "Thông tin cá nhân"));
        menuTL.addSubMenu(new MenuItem("TLGD", im.getIcon("contrast_25px.png"), "Giao diện"));
        menuTL.addSubMenu(new MenuItem("TT", im.getIcon("help_25px.png"), "About us"));

        sideBarController.addMenu(menuQLNV, menuQLNS, menuQLDS, menuQLDV, menuTK, menuTL);
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    // Tạo sự kiện
    private void addEvent() {
        view.getBtnLogout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
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
            }
        });
    }

    private void onMenuChange(MenuItem item) {
        switch (item.getId()) {
            case "QLNV"://Nhân viên
                view.setPanel(employeeManagerView);
                employeeManagerController.setView(employeeManagerView);
                employeeManagerController.updateData();
                break;
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
            case "QLTX"://Quản lý tài xế
                view.setPanel(driverManagerView);
                driverManagerController.setView(driverManagerView);
                driverManagerController.updateData();
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

            case "TK"://Thống kê chung
                view.setPanel(statisticalView);
                statisticalController.setView(statisticalView);
                statisticalController.initData();
                break;
            case "TKNV"://Thống kê nhân viên
                view.setPanel(statisticalEmployeeView);
                statisticalEmployeeController.setView(statisticalEmployeeView);
                statisticalEmployeeController.initData();
                break;
            case "TKDT"://Thống kê doanh thu
                view.setPanel(statisticalIncomeView);
                statisticalIncomeController.setView(statisticalIncomeView);
                statisticalIncomeController.initData();
                break;
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
