package views.employee;

import javax.swing.JLabel;


public class DayView extends javax.swing.JPanel {

    public DayView() {
        initComponents();
    }

    public JLabel getLabelNumber() {
        return labelNumber;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelNumber = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(60, 60));
        setMinimumSize(new java.awt.Dimension(60, 60));
        setPreferredSize(new java.awt.Dimension(60, 60));
        setLayout(new java.awt.GridBagLayout());

        labelNumber.setBackground(new java.awt.Color(240, 240, 200));
        labelNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(labelNumber, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelNumber;
    // End of variables declaration//GEN-END:variables
}
