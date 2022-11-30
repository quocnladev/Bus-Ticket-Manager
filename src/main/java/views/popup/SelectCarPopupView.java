package views.popup;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import models.ListBus;
import utils.ErrorPopup;
import views.CarRenderJList;

public class SelectCarPopupView extends javax.swing.JFrame {

    DefaultListModel<ListBus> carListModel = new DefaultListModel<ListBus>();

    public SelectCarPopupView() {
        initComponents();
        listCar.setModel(carListModel);
        listCar.setCellRenderer(new CarRenderJList());
        setPreferredSize(new Dimension(400, 500));
        getRootPane().setDefaultButton(btnSearch);
        setLocationRelativeTo(null);
    }

    public DefaultListModel<ListBus> getCarListModel() {
        return carListModel;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JTextField getTxtNhaxe() {
        return txtNhaxe;
    }

    public JTextField getTxtRoute() {
        return txtRoute;
    }
    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public JList<ListBus> getListCar() {
        return listCar;
    }

    public void setListCar(JList<ListBus> listCar) {
        this.listCar = listCar;
    }

    public void renderCar(ArrayList<ListBus> car) {
        carListModel.removeAllElements();
        for (ListBus lb : car) {
            carListModel.addElement(lb);
        }
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception message) {
        ErrorPopup.show(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtNhaxe = new javax.swing.JTextField();
        txtRoute = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCar = new JList<ListBus>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(429, 40));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Chọn xe");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(429, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("OK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnOK, gridBagConstraints);

        btnCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnCancel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel4.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(txtNhaxe, gridBagConstraints);

        btnSearch.setText("Tìm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(btnSearch, gridBagConstraints);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 350));

        listCar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listCar);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private JList<ListBus> listCar;
    private javax.swing.JTextField txtNhaxe;
    private javax.swing.JTextField txtRoute;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
