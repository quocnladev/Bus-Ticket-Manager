
package views.popup;

import javax.swing.*;

import utils.ErrorPopup;

import java.awt.event.ActionEvent;

public class ListBusPopupView extends javax.swing.JFrame implements PopupView {

    public ListBusPopupView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JTextField getTxtBienso() {
        return txtBienso;
    }

    public JComboBox<String> getCboType() {
        return cboType;
    }

    public JSpinner getSpnPrice() {
        return spnPrice;
    }

    public JSpinner getSpnNumber() {
        return spnNumber;
    }

    public JTextField getTxtNhaxe() {
        return txtNhaxe;
    }

    public JLabel getLbDriverName(){
        return lbDriverName;
    }
    public JButton getBtnSelectDriver() {
        return btnSelectDriver;
    }

    public JLabel getLbRoute(){
        return lbRoute;
    }
    public JButton getBtnSelectRoute() {
        return btnSelectRoute;
    }
    public JLabel getLbTime(){
        return lbTime;
    }
    public JButton getBtnSelectTime() {
        return btnSelectTime;
    }

    private void btnSelectDriverActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbBienso = new javax.swing.JLabel();
        txtBienso = new javax.swing.JTextField();
        lbNhaxe = new javax.swing.JLabel();
        txtNhaxe = new javax.swing.JTextField();
        lbLoaixe = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbTongsoghe = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        spnPrice = new javax.swing.JSpinner();
        spnNumber = new javax.swing.JSpinner();
        javax.swing.JLabel lbDName = new javax.swing.JLabel();
         lbDriverName = new javax.swing.JLabel();
        btnSelectDriver = new javax.swing.JButton();
        javax.swing.JLabel lbDName1 = new javax.swing.JLabel();
        lbRoute = new javax.swing.JLabel();
        btnSelectRoute = new javax.swing.JButton();
        javax.swing.JLabel lbDName2 = new javax.swing.JLabel();
         lbTime = new javax.swing.JLabel();
        btnSelectTime = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm xe");
        jPanel1.add(lbTitle, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Thêm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnOK, gridBagConstraints);

        btnCancel.setText("Hủy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnCancel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lbBienso.setText("Biển số xe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbBienso, gridBagConstraints);

        txtBienso.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtBienso, gridBagConstraints);

        lbNhaxe.setText("Nhà xe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbNhaxe, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtNhaxe, gridBagConstraints);

        lbLoaixe.setText("Loại xe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbLoaixe, gridBagConstraints);

        lbGia.setText("Giá vé:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbGia, gridBagConstraints);

        lbTongsoghe.setText("Tổng số ghế:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbTongsoghe, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboType, gridBagConstraints);

        spnPrice.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50000000, 100000));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnPrice, gridBagConstraints);

        spnNumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50000000, 100000));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnNumber, gridBagConstraints);

        lbDName.setText("Tên tài xế:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDName, gridBagConstraints);

        lbDriverName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDriverName.setForeground(new java.awt.Color(255, 51, 51));
        lbDriverName.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDriverName, gridBagConstraints);

        btnSelectDriver.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(btnSelectDriver, gridBagConstraints);

        lbDName1.setText("Tuyến đường");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDName1, gridBagConstraints);

        lbRoute.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbRoute.setForeground(new java.awt.Color(255, 51, 51));
        lbRoute.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbRoute, gridBagConstraints);

        btnSelectRoute.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(btnSelectRoute, gridBagConstraints);

        lbDName2.setText("Thời gian:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDName2, gridBagConstraints);

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 51, 51));
        lbTime.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbTime, gridBagConstraints);

        btnSelectTime.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(btnSelectTime, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSelectDriver;
    private javax.swing.JButton btnSelectRoute;
    private javax.swing.JButton btnSelectTime;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbBienso;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbLoaixe;
    private javax.swing.JLabel lbNhaxe;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTongsoghe;
    private javax.swing.JLabel lbDriverName;
    private javax.swing.JLabel lbRoute;
    private javax.swing.JLabel lbTime;

    private javax.swing.JSpinner spnNumber;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JTextField txtBienso;
    private javax.swing.JTextField txtNhaxe;
    // End of variables declaration//GEN-END:variables

}
