package views.admin;

import models.Time;
import javax.swing.*;

public class TimeManagerView extends ManagerPaneView<Time> {

    String[] list = {"startTime", "endTime"};

    public TimeManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Thời gian xuất phát");
        tableModel.addColumn("Thời gian đến");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
