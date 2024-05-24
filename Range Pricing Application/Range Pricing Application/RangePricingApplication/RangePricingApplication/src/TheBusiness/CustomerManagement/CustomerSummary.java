/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.OrderManagement.Order;
import TheBusiness.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class CustomerSummary {

    CustomerProfile customer;
    int ordertotal;
    Product product;

    public CustomerSummary(CustomerProfile cp, Product product, int ordertotal) {
        this.customer = cp;
        this.product = product;
        this.ordertotal = ordertotal;
    }
    public CustomerSummary(CustomerProfile cp) {
        this.customer = cp;    }

}
