/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Sales;

import TheBusiness.Business.Business;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.UserAccountManagement.UserAccount;
import java.awt.CardLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author harsh
 */
public class SaleManageOrdersPanel extends javax.swing.JPanel {
    
    JPanel ContentPanel;
    Business business;
    UserAccount ua;

    /**
     * Creates new form SaleManageOrdersPanel
     *
     * @param business
     * @param ua
     * @param ContentPanel
     */
    public SaleManageOrdersPanel(Business business, UserAccount ua,
            JPanel ContentPanel) {
        initComponents();
        
        this.business = business;
        this.ContentPanel = ContentPanel;
        this.ua = ua;
        
        loadProductComboDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        backToDashButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        productCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        orderCB = new javax.swing.JComboBox<>();
        customerTB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        floorPriceTB = new javax.swing.JTextField();
        ceilingPriceTB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        targetPriceTB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Manage Orders");

        backToDashButton.setBackground(new java.awt.Color(51, 153, 255));
        backToDashButton.setText("<< Back");
        backToDashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToDashButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Product :");

        productCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCBActionPerformed(evt);
            }
        });

        jLabel4.setText("Order :");

        orderCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCBActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer :");

        jLabel5.setText("Floor :");

        jLabel6.setText("Ceiling :");

        jLabel7.setText("Target :");

        jLabel8.setText("Order Status : ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Created", "Accepted", "Getting Packed", "Dispatched", "In Transit", "Delivered" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setText("Update");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Cencel Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 252, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(236, 236, 236))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backToDashButton)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ceilingPriceTB)
                                    .addComponent(customerTB)
                                    .addComponent(productCB, 0, 215, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, 0, 216, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(37, 37, 37)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(orderCB, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(floorPriceTB))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(targetPriceTB))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(backToDashButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(orderCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(floorPriceTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ceilingPriceTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(targetPriceTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToDashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToDashButtonActionPerformed
        // TODO add your handling code here:
        SalesDashboardPanel adminPanel
                = new SalesDashboardPanel(business, ua, ContentPanel);
        ContentPanel.add("SalesDash", adminPanel);
        CardLayout layout = (CardLayout) ContentPanel.getLayout();
        layout.next(ContentPanel);
    }//GEN-LAST:event_backToDashButtonActionPerformed

    private void productCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCBActionPerformed
        // TODO add your handling code here:
        if (this.productCB.getSelectedItem() != null) {
            String prodName = this.productCB.getSelectedItem().toString();
            loadProductOrderComboDetails(prodName);
        }
    }//GEN-LAST:event_productCBActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void orderCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCBActionPerformed
        // TODO add your handling code here:
        if (this.orderCB.getSelectedItem() != null) {
            String prodName = this.productCB.getSelectedItem().toString();
            String orderCount = this.orderCB.getSelectedItem().toString();
            loadProductCustPriceDetails(prodName, orderCount);
        }
    }//GEN-LAST:event_orderCBActionPerformed
    
    private void loadProductComboDetails() {
        DefaultComboBoxModel prodcb = (DefaultComboBoxModel) productCB.getModel();
        prodcb.removeAllElements();
        prodcb.addElement("Select");
        Set<String> prodSet = new HashSet<>();
        
        for (Order order : business.getMasterOrderList().getOrders()) {
            if (order.getSalesperson().getPerson().isMatch(ua.getPersonId())) {
                for (OrderItem ordItm : order.getOrderitems()) {
                    prodSet.add(ordItm.getSelectedProduct().getName());
                }
            }
        }
        if (!prodSet.isEmpty()) {
            prodcb.addAll(prodSet);
        }
    }
    
    private void loadProductOrderComboDetails(final String prodName) {
        DefaultComboBoxModel ordcb = (DefaultComboBoxModel) orderCB.getModel();
        ordcb.removeAllElements();
        ordcb.addElement("Select");
        Set<String> ordSet = new HashSet<>();
        int orderCounter = 1;
        for (Order order : business.getMasterOrderList().getOrders()) {
            if (order.getSalesperson().getPerson().isMatch(ua.getPersonId())) {
                for (OrderItem ordItm : order.getOrderitems()) {
                    if (ordItm.getSelectedProduct().getName().equalsIgnoreCase(prodName)) {
                        ordSet.add("Order_" + orderCounter);
                        orderCounter++;
                    }
                }
            }
        }
        if (!ordSet.isEmpty()) {
            ordcb.addAll(ordSet);
        }
    }
    
    private void loadProductCustPriceDetails(final String prodName, final String orderCntr) {
        if (orderCntr.contains("_")) {
            String[] ordCntArr = orderCntr.split("_");
            int orderCounter = Integer.parseInt(ordCntArr[1]);
            int loopCounter = 1;
            for (Order order : business.getMasterOrderList().getOrders()) {
                if (order.getSalesperson().getPerson().isMatch(ua.getPersonId())) {
                    for (OrderItem ordItm : order.getOrderitems()) {
                        if (ordItm.getSelectedProduct().getName().equalsIgnoreCase(prodName)) {
                            if (loopCounter == orderCounter) {
                                customerTB.setText(order.getCustomer().getCustomerId());
                                floorPriceTB.setText(ordItm.getSelectedProduct().getFloorPrice() + "");
                                ceilingPriceTB.setText(ordItm.getSelectedProduct().getCeilingPrice() + "");
                                targetPriceTB.setText(ordItm.getSelectedProduct().getTargetPrice() + "");
                                break;
                            }
                            loopCounter++;
                        }
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToDashButton;
    private javax.swing.JTextField ceilingPriceTB;
    private javax.swing.JTextField customerTB;
    private javax.swing.JTextField floorPriceTB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> orderCB;
    private javax.swing.JComboBox<String> productCB;
    private javax.swing.JTextField targetPriceTB;
    // End of variables declaration//GEN-END:variables
}
