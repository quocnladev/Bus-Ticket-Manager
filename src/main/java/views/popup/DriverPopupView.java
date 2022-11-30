package views.popup;

import javax.swing.*;

import utils.ErrorPopup;

public class DriverPopupView extends javax.swing.JFrame implements PopupView {

    public DriverPopupView() {
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
    public JSpinner getSpnStartDate() {
        return spnStartDate;
    }
    public JCheckBox getCbUnknownStartDate() {
        return cbUnknownStartDate;
    }
    public JSpinner getSpnSalary() {
        return spnSalary;
    }
    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtName() {
        return txtName;
    }
    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        spnSalary = new javax.swing.JSpinner();
        lbStartDate = new javax.swing.JLabel();
        spnStartDate = new javax.swing.JSpinner();
        cbUnknownStartDate = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm tài xế");
        jPanel1.add(lbTitle, new java.awt.GridBagConstraints());
        lbTitle.getAccessibleContext().setAccessibleParent(lbTitle);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 75));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnCancel.setText("Hủy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnCancel, gridBagConstraints);

        btnOK.setText("Thêm");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnOK, gridBagConstraints);
        btnOK.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtAddress, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtName, gridBagConstraints);
        txtName.getAccessibleContext().setAccessibleName("");
        txtName.getAccessibleContext().setAccessibleDescription("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtPhoneNumber, gridBagConstraints);

        lbPhone.setText("Số điện thoại:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbPhone, gridBagConstraints);

        lbName.setText("Họ và Tên:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbName, gridBagConstraints);

        lbSalary.setText("Lương:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbSalary, gridBagConstraints);

        lbAddress.setText("Địa Chỉ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbAddress, gridBagConstraints);

        spnSalary.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50000000, 100000));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnSalary, gridBagConstraints);

        lbStartDate.setText("Ngày bắt đầu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbStartDate, gridBagConstraints);

        spnStartDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(955342800000L), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnStartDate, gridBagConstraints);

        cbUnknownStartDate.setText("Không rõ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cbUnknownStartDate, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox cbUnknownStartDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JLabel lbStartDate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JSpinner spnSalary;
    private javax.swing.JSpinner spnStartDate;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
