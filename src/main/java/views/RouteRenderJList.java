package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import models.Route;

public class RouteRenderJList extends javax.swing.JPanel implements ListCellRenderer<Route> {

    public RouteRenderJList() {
        initComponents();
        setPreferredSize(new Dimension(400, 75));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDepart = new javax.swing.JLabel();
        lbDestination = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Xuất phát:");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nơi đến:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel2, gridBagConstraints);

        lbDepart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDepart.setText("Đà Lạt");
        lbDepart.setToolTipText("");
        lbDepart.setNextFocusableComponent(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        add(lbDepart, gridBagConstraints);

        lbDestination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDestination.setText("Tây Ninh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        add(lbDestination, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbDepart;
    private javax.swing.JLabel lbDestination;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Route> list, Route route, int index, boolean isSelected, boolean cellHasFocus) {
        lbDepart.setText(route.getDepart());
        lbDestination.setText(route.getDestination());
//        lbSalary.setText(String.format("(%s)", route.getSalary()));
        if (cellHasFocus) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(new Color(242, 242, 242));
        }
        return this;
    }
}
