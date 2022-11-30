package views.popup;

import javax.swing.*;

import utils.ErrorPopup;

public class TimePopupView extends javax.swing.JFrame implements PopupView {

    public TimePopupView() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbKhoihanh = new javax.swing.JLabel();
        lbGioden = new javax.swing.JLabel();
        spnStartTime = new javax.swing.JSpinner();
        cbUnknownStartTime = new javax.swing.JCheckBox();
        spnEndTime = new javax.swing.JSpinner();
        cbUnknownEndTime = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm thời gian");
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

        lbKhoihanh.setText("Giờ khởi hành:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbKhoihanh, gridBagConstraints);

        lbGioden.setText("Giờ đến:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbGioden, gridBagConstraints);

        spnStartTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(955342800000L), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnStartTime, gridBagConstraints);

        cbUnknownStartTime.setText("Không rõ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cbUnknownStartTime, gridBagConstraints);

        spnEndTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(955342800000L), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnEndTime, gridBagConstraints);

        cbUnknownEndTime.setText("Không rõ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cbUnknownEndTime, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

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
    public JSpinner getSpnStartTime() {
        return spnStartTime;
    }
    public JCheckBox getCbUnknownStartTime() {
        return cbUnknownStartTime;
    }

    public JSpinner getSpnEndTime() {
        return spnEndTime;
    }
    public JCheckBox getCbUnknownEndTime() {
        return cbUnknownEndTime;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox cbUnknownEndTime;
    private javax.swing.JCheckBox cbUnknownStartTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbGioden;
    private javax.swing.JLabel lbKhoihanh;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JSpinner spnEndTime;
    private javax.swing.JSpinner spnStartTime;
    // End of variables declaration//GEN-END:variables

}
