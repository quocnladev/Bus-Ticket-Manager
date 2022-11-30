package views.admin;

import models.Route;
import javax.swing.*;

public class RouteManagerView extends ManagerPaneView<Route> {

    String[] list = {"depart", "destination", "length"};

    public RouteManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Điểm xuất phát");
        tableModel.addColumn("Điểm đến");
        tableModel.addColumn("Độ dài");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
