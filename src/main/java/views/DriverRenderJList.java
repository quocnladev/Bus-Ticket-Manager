package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import models.Driver;

public class DriverRenderJList extends javax.swing.JPanel implements ListCellRenderer<Driver> {

    public DriverRenderJList() {
        initComponents();
        setPreferredSize(new Dimension(400, 75));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbName = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbPhoneNumber = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 0, 0));
        lbName.setText("NLA Quốc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(lbName, gridBagConstraints);

        lbAddress.setText("Tây Ninh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(lbAddress, gridBagConstraints);

        lbPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPhoneNumber.setText("(0393999999)");
        lbPhoneNumber.setToolTipText("");
        lbPhoneNumber.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        add(lbPhoneNumber, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhoneNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Driver> list, Driver driver, int index, boolean isSelected, boolean cellHasFocus) {
        lbName.setText(driver.getName());
        lbAddress.setText(driver.getAddress());
        lbPhoneNumber.setText(String.format("(%s)", driver.getPhoneNumber()));
//        lbSalary.setText(String.format("(%s)", driver.getSalary()));
        if (cellHasFocus) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(new Color(242, 242, 242));
        }
        return this;
    }
}
