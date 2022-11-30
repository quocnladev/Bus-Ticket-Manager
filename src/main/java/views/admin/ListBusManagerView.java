package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.ListBus;

public class ListBusManagerView extends ManagerPaneView<ListBus> {

    String[] list = {"none"};

    public ListBusManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Biển số");
        tableModel.addColumn("Nhà xe");
        tableModel.addColumn("Loại xe");
        tableModel.addColumn("Giá");
        tableModel.addColumn("Số chỗ");
        tableModel.addColumn("Tên tài xế");
        tableModel.addColumn("Tuyến đường");
        tableModel.addColumn("Thời gian");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
