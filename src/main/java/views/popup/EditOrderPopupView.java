
package views.popup;
import javax.swing.*;

import utils.ErrorPopup;

public class EditOrderPopupView extends javax.swing.JFrame implements PopupView {

    public EditOrderPopupView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnlLeft = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lbIdOrder = new javax.swing.JLabel();
        lbEmployeeName = new javax.swing.JLabel();
        spnNumber = new javax.swing.JSpinner();
        javax.swing.JLabel lbDName1 = new javax.swing.JLabel();
        lbCustumerName = new javax.swing.JLabel();
        btnSelectCustomer = new javax.swing.JButton();
        javax.swing.JLabel lbDName2 = new javax.swing.JLabel();
        lbCar = new javax.swing.JLabel();
        btnSelectCar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTotalAmount = new javax.swing.JLabel();
        lbFinalAmount = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbPaidAmount = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        btnPaid = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPrintOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        pnlTop.setPreferredSize(new java.awt.Dimension(500, 40));

        pnlTop.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Cập nhật hóa đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        pnlTop.add(lbTitle, gridBagConstraints);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlLeft.setPreferredSize(new java.awt.Dimension(400, 300));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chỉnh sửa thông tin"));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 200));
        jPanel3.setPreferredSize(new java.awt.Dimension(440, 300));

        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nhân viên:");
        jLabel2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Số vé:");
        jLabel3.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Loại hóa đơn:");
        jLabel4.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboType, gridBagConstraints);

        jLabel17.setText("Mã HD:");
        jLabel17.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel17, gridBagConstraints);

        lbIdOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbIdOrder.setText("001");
        lbIdOrder.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbIdOrder, gridBagConstraints);

        lbEmployeeName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmployeeName.setForeground(new java.awt.Color(255, 0, 0));
        lbEmployeeName.setText("Quốc");
        lbEmployeeName.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbEmployeeName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnNumber, gridBagConstraints);

        lbDName1.setText("Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDName1, gridBagConstraints);

        lbCustumerName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCustumerName.setForeground(new java.awt.Color(255, 51, 51));
        lbCustumerName.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbCustumerName, gridBagConstraints);

        btnSelectCustomer.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel3.add(btnSelectCustomer, gridBagConstraints);

        lbDName2.setText("Xe:");
        lbDName2.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDName2, gridBagConstraints);

        lbCar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCar.setForeground(new java.awt.Color(255, 51, 51));
        lbCar.setText("Chưa chọn");
        lbCar.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbCar, gridBagConstraints);

        btnSelectCar.setText("Chọn");
        btnSelectCar.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel3.add(btnSelectCar, gridBagConstraints);

        jLabel5.setText("Thanh toán:");
        jLabel5.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboStatus, gridBagConstraints);

        pnlLeft.add(jPanel3, java.awt.BorderLayout.CENTER);
        jPanel3.getAccessibleContext().setAccessibleDescription("");
        jPanel3.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(pnlLeft, java.awt.BorderLayout.LINE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Tổng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Đã Thanh Toán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel8, gridBagConstraints);

        lbTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbTotalAmount.setText("100,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbTotalAmount, gridBagConstraints);

//        lbFinalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        lbFinalAmount.setForeground(new java.awt.Color(255, 0, 0));
//        lbFinalAmount.setText("120,000,000");
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 2;
//        gridBagConstraints.gridy = 3;
//        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
//        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
//        jPanel5.add(lbFinalAmount, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel14, gridBagConstraints);

//        jLabel10.setText("Phải Trả");
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 3;
//        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
//        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
//        jPanel5.add(jLabel10, gridBagConstraints);

        lbPaidAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPaidAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbPaidAmount.setText("120,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbPaidAmount, gridBagConstraints);

//        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        jLabel16.setText("VND");
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 3;
//        gridBagConstraints.gridy = 3;
//        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
//        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
//        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel18.setText("Trạng thái:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel18, gridBagConstraints);

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 0, 0));
        lbStatus.setText("Chưa thanh toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbStatus, gridBagConstraints);

        getContentPane().add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel4.setMinimumSize(new java.awt.Dimension(50, 120));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(50, 120));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Cập Nhật");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnOK, gridBagConstraints);

        btnCancelOrder.setText("Hủy Hóa Đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnCancelOrder, gridBagConstraints);

        btnPaid.setText("Thanh Toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPaid, gridBagConstraints);

        btnCancel.setText("Đóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnCancel, gridBagConstraints);

        btnPrintOrder.setText("In Hóa Đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPrintOrder, gridBagConstraints);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    @Override
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnCancelOrder() {
        return btnCancelOrder;
    }

    public JButton getBtnPrintOrder() {
        return btnPrintOrder;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JButton getBtnPaid() {
        return btnPaid;
    }

    public JComboBox<String> getCboType() {
        return cboType;
    }

    public JLabel getLbFinalAmount() {
        return lbFinalAmount;
    }

    public JLabel getLbIdOrder() {
        return lbIdOrder;
    }

    public JLabel getLbPaidAmount() {
        return lbPaidAmount;
    }

    @Override
    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JLabel getLbTotalAmount() {
        return lbTotalAmount;
    }

    public JLabel getLbEmployeeName() {
        return lbEmployeeName;
    }

    public JLabel getLbCustomerName(){
        return lbCustumerName;
    }
    public JLabel getLbCar(){
        return lbCar;
    }

    public JLabel getLbStatus() {
        return lbStatus;
    }
    public JButton getBtnSelectCustomer() {
        return btnSelectCustomer;
    }

    public JButton getBtnSelectCar() {
        return btnSelectCar;
    }
    public JComboBox getCboStatus(){
        return cboStatus;
    }

    public JSpinner getSpnNumber(){
        return spnNumber;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPaid;
    private javax.swing.JButton btnPrintOrder;
    private javax.swing.JButton btnSelectCar;
    private javax.swing.JButton btnSelectCustomer;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbEmployeeName;
    private javax.swing.JLabel lbFinalAmount;
    private javax.swing.JLabel lbIdOrder;
    private javax.swing.JLabel lbPaidAmount;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAmount;
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbCustumerName;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JSpinner spnNumber;
    // End of variables declaration//GEN-END:variables

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
