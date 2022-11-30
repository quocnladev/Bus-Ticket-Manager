package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.BookTicket;

public class BookTicketManagerView extends ManagerPaneView<BookTicket> {

    String[] list = {"none"};

    public BookTicketManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Người lập");
        tableModel.addColumn("Khách hàng");
        tableModel.addColumn("Nhà xe");
        tableModel.addColumn("Tuyến đường");
        tableModel.addColumn("Giá");
        tableModel.addColumn("Loại");
        tableModel.addColumn("Đã Thanh Toán");
        tableModel.addColumn("Ngày đặt vé");

        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
