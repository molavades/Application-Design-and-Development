/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    private CustomerProfile customer;
    private SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;
    private ArrayList<OrderItem> orderitems;

    public Order() {
    }

    public Order(CustomerProfile cp) {
        orderitems = new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson = null;
        status = "in process";
    }

    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        orderitems = new ArrayList();
        customer = cp;
        salesperson = ep;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson.addSalesOrder(this);
    }

    public OrderItem newOrderItem(Product p, int actualprice, int q) {
        OrderItem oi = new OrderItem(p, actualprice, q);
        getOrderitems().add(oi);
        return oi;
    }

    /**
     * @return the orderitems
     */
    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }

    /**
     * @return the customer
     */
    public CustomerProfile getCustomer() {
        return customer;
    }

    /**
     * @return the salesperson
     */
    public SalesPersonProfile getSalesperson() {
        return salesperson;
    }

    //order total is the sumer of the order item totals
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getCountOrderItems() {
        int count = 0;
        for (OrderItem oi : orderitems) {
            count++;
        }
        return count;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    //sum all the item targets and compare to the total of the order 
    public boolean isOrderAboveTotalTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTargetTotal(); //product targets are added
        }
        if (getOrderTotal() > sum) {
            return true;
        } else {
            return false;
        }

    }

    public void CancelOrder() {
        status = "Cancelled";
    }

    public void Submit() {
        status = "Submitted";
    }
}
