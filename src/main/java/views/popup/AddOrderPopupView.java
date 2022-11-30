package views.popup;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import utils.ErrorPopup;

public class AddOrderPopupView extends javax.swing.JFrame implements PopupView {

    public AddOrderPopupView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel lbDName1 = new javax.swing.JLabel();
        lbCustumerName = new javax.swing.JLabel();
        btnSelectCustomer = new javax.swing.JButton();
        javax.swing.JLabel lbDName2 = new javax.swing.JLabel();
        lbCar = new javax.swing.JLabel();
        btnSelectCar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 40));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Tạo Hóa Đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(lbTitle, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Tạo");
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

        jPanel4.setLayout(new java.awt.GridBagLayout());
        jPanel4.add(jLabel5, new java.awt.GridBagConstraints());

        lbDName1.setText("Khách hàng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(lbDName1, gridBagConstraints);
        lbDName1.getAccessibleContext().setAccessibleName("");
        lbDName1.getAccessibleContext().setAccessibleDescription("");

        lbCustumerName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCustumerName.setForeground(new java.awt.Color(255, 51, 51));
        lbCustumerName.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(lbCustumerName, gridBagConstraints);

        btnSelectCustomer.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnSelectCustomer, gridBagConstraints);

        lbDName2.setText("Xe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(lbDName2, gridBagConstraints);
        lbDName2.getAccessibleContext().setAccessibleName("");
        lbDName2.getAccessibleContext().setAccessibleDescription("");

        lbCar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCar.setForeground(new java.awt.Color(255, 51, 51));
        lbCar.setText("Chưa chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(lbCar, gridBagConstraints);

        btnSelectCar.setText("Chọn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnSelectCar, gridBagConstraints);

        jLabel4.setText("Loại hóa đơn:");
        jLabel4.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel4, gridBagConstraints);
        jLabel4.getAccessibleContext().setAccessibleName("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(cboType, gridBagConstraints);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JLabel getLbCustomerName(){
        return lbCustumerName;
    }
    public JLabel getLbCar(){
        return lbCar;
    }

    public JButton getBtnSelectCustomer() {
        return btnSelectCustomer;
    }

    public JButton getBtnSelectCar() {
        return btnSelectCar;
    }

    public JComboBox getCboType(){
        return cboType;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSelectCar;
    private javax.swing.JButton btnSelectCustomer;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbCustumerName;
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
