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
        MenuItem menuQLNV = new MenuItem("QLNV", im.getIcon("user_groups_25px.png"), "Qu???n l?? nh??n vi??n");
        MenuItem menuQLNS = new MenuItem("QLNS", im.getIcon("user_groups_25px.png"), "Qu???n l?? nh??n s???");
        MenuItem menuQLDS = new MenuItem("QLDS", im.getIcon("cardboard_box_25px.png"), "Qu???n l?? ds xe");
        MenuItem menuQLDV = new MenuItem("QLDDV", im.getIcon("shopping_cart_25px.png"), "Qu???n l?? ?????t v??");
        MenuItem menuTK = new MenuItem("TK", im.getIcon("increase_25px.png"), "Th???ng k??");
        MenuItem menuTL = new MenuItem("TL", im.getIcon("settings_25px.png"), "Thi???t l???p");

        menuQLDS.addSubMenu(new MenuItem("QLDSXe", null, "Qu???n l?? ds xe"));
        menuQLDS.addSubMenu(new MenuItem("QLDRoute", null, "Qu???n l?? tuy???n ???????ng"));
        menuQLDS.addSubMenu(new MenuItem("QLDTime", null, "Qu???n l?? th???i gian"));

        menuQLNS.addSubMenu(new MenuItem("QLKH", im.getIcon("technical_support_25px.png"), "Qu???n l?? kh??ch h??ng"));
        menuQLNS.addSubMenu(new MenuItem("QLTX", im.getIcon("technical_support_25px.png"), "Qu???n l?? t??i x???"));


        menuTK.addSubMenu(new MenuItem("TKNV", im.getIcon("user_25px.png"), "Th???ng k?? nh??n vi??n"));
        menuTK.addSubMenu(new MenuItem("TKDT", null, "Th???ng k?? doanh thu"));

        menuTL.addSubMenu(new MenuItem("TTCN", im.getIcon("about_25px.png"), "Th??ng tin c?? nh??n"));
        menuTL.addSubMenu(new MenuItem("TLGD", im.getIcon("contrast_25px.png"), "Giao di???n"));
        menuTL.addSubMenu(new MenuItem("TT", im.getIcon("help_25px.png"), "About us"));

        sideBarController.addMenu(menuQLNV, menuQLNS, menuQLDS, menuQLDV, menuTK, menuTL);
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    // T???o s??? ki???n
    private void addEvent() {
        view.getBtnLogout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                int confirm = JOptionPane.showConfirmDialog(view, "B???n th???c s??? mu???n ????ng xu???t?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
                try {
                    SessionManager.update();// ?????ng xu???t
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
            case "QLNV"://Nh??n vi??n
                view.setPanel(employeeManagerView);
                employeeManagerController.setView(employeeManagerView);
                employeeManagerController.updateData();
                break;
            case "QLDDV"://?????t v??
                view.setPanel(bookTicketManagerView);
                bookTicketManagerController.setView(bookTicketManagerView);
                bookTicketManagerController.updateData();
                break;

            case "QLKH"://Qu???n l?? kh??ch h??ng
                view.setPanel(customerManagerView);
                customerManagerController.setView(customerManagerView);
                customerManagerController.updateData();
                break;
            case "QLTX"://Qu???n l?? t??i x???
                view.setPanel(driverManagerView);
                driverManagerController.setView(driverManagerView);
                driverManagerController.updateData();
                break;
            case "QLDSXe"://Qu???n l?? ds xe
                view.setPanel(listBusManagerView);
                listBusManagerController.setView(listBusManagerView);
                listBusManagerController.updateData();
                break;
            case "QLDRoute"://Qu???n l?? tuy???n ???????ng
                view.setPanel(routeManagerView);
                routeManagerController.setView(routeManagerView);
                routeManagerController.updateData();
                break;
            case "QLDTime"://Qu???n l?? th???i gian
                view.setPanel(timeManagerView);
                timeManagerController.setView(timeManagerView);
                timeManagerController.updateData();
                break;

            case "QLHH":break;
            case "QLDH":break;
            case "TL":break;

            case "TK"://Th???ng k?? chung
                view.setPanel(statisticalView);
                statisticalController.setView(statisticalView);
                statisticalController.initData();
                break;
            case "TKNV"://Th???ng k?? nh??n vi??n
                view.setPanel(statisticalEmployeeView);
                statisticalEmployeeController.setView(statisticalEmployeeView);
                statisticalEmployeeController.initData();
                break;
            case "TKDT"://Th???ng k?? doanh thu
                view.setPanel(statisticalIncomeView);
                statisticalIncomeController.setView(statisticalIncomeView);
                statisticalIncomeController.initData();
                break;
            case "TT"://Th??ng tin
                view.setPanel(aboutView);
                break;
            case "TTCN": // Th???ng tin c?? nh??n
                view.setPanel(informationView);
                informationController.setView(informationView);
                break;
            default:
                view.setPanel(homeView);
                break;
        }
    }
}
