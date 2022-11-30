package views.popup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.ErrorPopup;

public class RoutePopupView extends javax.swing.JFrame implements PopupView {

    public RoutePopupView() {
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
        lbXuatphat = new javax.swing.JLabel();
        txtXuatphat = new javax.swing.JTextField();
        lbDiemden = new javax.swing.JLabel();
        txtDiemden = new javax.swing.JTextField();
        lbChieudai = new javax.swing.JLabel();
        txtChieudai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm tuyến đường");
        jPanel1.add(lbTitle, new java.awt.GridBagConstraints());
        lbTitle.getAccessibleContext().setAccessibleName("Thêm tuyến đường");

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

        lbXuatphat.setText("Điểm xuất phát:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbXuatphat, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtXuatphat, gridBagConstraints);

        lbDiemden.setText("Điểm đến:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbDiemden, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtDiemden, gridBagConstraints);

        lbChieudai.setText("Chiều dài:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbChieudai, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtChieudai, gridBagConstraints);

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

    public JTextField getTxtDepart() {
        return txtXuatphat;
    }
    public JTextField getTxtDestination() {
        return txtDiemden;
    }
    public JTextField getTxtLength() {
        return txtChieudai;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbChieudai;
    private javax.swing.JLabel lbDiemden;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbXuatphat;
    private javax.swing.JTextField txtChieudai;
    private javax.swing.JTextField txtDiemden;
    private javax.swing.JTextField txtXuatphat;
    // End of variables declaration//GEN-END:variables

}
