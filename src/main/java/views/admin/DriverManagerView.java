package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.Driver;

public class DriverManagerView extends ManagerPaneView<Driver> {

    String[] list = { "name", "phoneNumber", "address"};

    public DriverManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Họ và tên");
        tableModel.addColumn("Số điện thoại");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Ngày vào làm");
        tableModel.addColumn("Lương");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
