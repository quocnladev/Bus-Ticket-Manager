package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import models.ListBus;

public class CarRenderJList extends javax.swing.JPanel implements ListCellRenderer<ListBus> {

    public CarRenderJList() {
        initComponents();
        setPreferredSize(new Dimension(400, 75));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNhaxe = new javax.swing.JLabel();
        lbRoute = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nhà xe:");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tuyến đường:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel2, gridBagConstraints);

        lbNhaxe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNhaxe.setText("Đà Lạt");
        lbNhaxe.setToolTipText("");
        lbNhaxe.setNextFocusableComponent(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        add(lbNhaxe, gridBagConstraints);

        lbRoute.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRoute.setText("Tây Ninh - HCM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        add(lbRoute, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Giá:");
        jLabel3.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel3, gridBagConstraints);

        lbPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPrice.setText("$$$$$");
        lbPrice.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        add(lbPrice, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbNhaxe;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbRoute;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends ListBus> list, ListBus lb, int index, boolean isSelected, boolean cellHasFocus) {
        lbNhaxe.setText(lb.getNhaxe());
        lbRoute.setText(lb.getRoute().getDepart().toString() +
        " - " + lb.getRoute().getDestination().toString());
        lbPrice.setText(String.valueOf(lb.getPrice()));
        if (cellHasFocus) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(new Color(242, 242, 242));
        }
        return this;
    }
}
