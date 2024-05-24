/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.Business.Business;
import TheBusiness.Personnel.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    /**
     * @param customerlist the customerlist to set
     */
    public void setCustomerlist(ArrayList<CustomerProfile> customerlist) {
        this.customerlist.addAll(customerlist);
    }

    Business business;
    private ArrayList<CustomerProfile> customerlist;

    /**
     * @return the customerlist
     */
    public ArrayList<CustomerProfile> getCustomerlist() {
        return customerlist;
    }

    public CustomerDirectory(Business d) {

        business = d;
        customerlist = new ArrayList();

    }

    public CustomerProfile newCustomerProfile(Person p) {

        CustomerProfile sp = new CustomerProfile(p);
        getCustomerlist().add(sp);
        return sp;
    }

    public CustomerProfile findCustomer(String id) {

        for (CustomerProfile sp : getCustomerlist()) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public CustomersReport generatCustomerPerformanceReport() {
        CustomersReport customersreport = new CustomersReport();

        for (CustomerProfile cp : getCustomerlist()) {

            CustomerSummary cs = new CustomerSummary(cp);
            customersreport.addCustomerSummary(cs);
        }
        return customersreport;
    }
}
