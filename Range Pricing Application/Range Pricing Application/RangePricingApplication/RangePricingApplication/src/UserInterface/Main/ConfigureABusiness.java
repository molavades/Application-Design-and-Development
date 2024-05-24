/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import TheBusiness.*;
import TheBusiness.MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales P1");
        Person xeroxsalesperson002 = persondirectory.newPerson("Xerox sales P2");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

// Create Sales people
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile_1 = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);
        SalesPersonProfile salespersonprofile_2 = salespersondirectory.newSalesPersonProfile(xeroxsalesperson002);

// Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount uas1 = uadirectory.newUserAccount(salespersonprofile_1, "Sales_1", "sales"); /// order products for one of the customers and performed by a sales person
        UserAccount uas2 = uadirectory.newUserAccount(salespersonprofile_2, "Sales_2", "sales"); /// order products for one of the customers and performed by a sales person
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "marketing"); /// order products for one of the customers and performed by a sales person
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "admin");

// Create person objects to represent customer organizations. 
        Person person005 = persondirectory.newPerson("Dell");
        Person person006 = persondirectory.newPerson("Microsoft");
        Person person007 = persondirectory.newPerson("Google");
        Person person008 = persondirectory.newPerson("JP Morgan");
        Person person009 = persondirectory.newPerson("State street"); //we use this as customer

// Create Customers
        CustomerDirectory customedirectory = business.getCustomerDirectory();
        CustomerProfile customerprofile1 = customedirectory.newCustomerProfile(person005);
        CustomerProfile customerprofile2 = customedirectory.newCustomerProfile(person006);
        CustomerProfile customerprofile3 = customedirectory.newCustomerProfile(person007);
        CustomerProfile customerprofile4 = customedirectory.newCustomerProfile(person008);
        CustomerProfile customerprofile5 = customedirectory.newCustomerProfile(person009);

        // Read Customer Details From CSV Files
        customedirectory.setCustomerlist(ReadCSVFileData.readCustomerCSVFileData(customedirectory));

        SupplierDirectory suplierdirectory = business.getSupplierDirectory();

        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
        ProductCatalog productcatalog = supplier1.getProductCatalog();
        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);

        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
        productcatalog = supplier2.getProductCatalog();
        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
        Product products2p2 = productcatalog.newProduct("Scanner 14", 9000, 16500, 12500);
        Product products2p3 = productcatalog.newProduct("Color Printer 112", 42200, 54000, 49000);
        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 43000, 89000, 55000);
        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 19500, 50100, 36502);
        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 90000, 12500, 16000);
        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 32200, 47000, 43650);
        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 35000, 58000, 38000);

// Read Prodcuts from the CSV File
        Map<String, List<Product>> supplierProdMap = ReadCSVFileData.readProductCSVFileData();
        Set<String> supProMapKeys = supplierProdMap.keySet();
        for (String key : supProMapKeys) {
            Supplier csvSupplier = suplierdirectory.newSupplier(key);
            productcatalog = csvSupplier.getProductCatalog();
            List<Product> prodList = supplierProdMap.get(key);
            for (Product prod : prodList) {
                productcatalog.getProductList().add(prod);
            }
        }

// Process Orders on behalf of sales person and customer
        MasterOrderList masterorderlist = business.getMasterOrderList();
        Order order1 = masterorderlist.newOrder(customerprofile1, salespersonprofile_1);
        OrderItem oi1_1 = order1.newOrderItem(products1p1, 10000, 1);
        OrderItem oi1_2 = order1.newOrderItem(products1p2, 16500, 4);
        OrderItem oi1_3 = order1.newOrderItem(products1p3, 40000, 10);
        OrderItem oi1_4 = order1.newOrderItem(products1p4, 50000, 1);
        OrderItem oi1_5 = order1.newOrderItem(products1p5, 25000, 3);
        OrderItem oi1_6 = order1.newOrderItem(products1p6, 105000, 2);
        OrderItem oi1_7 = order1.newOrderItem(products1p7, 36500, 3);
        OrderItem oi1_8 = order1.newOrderItem(products1p8, 50000, 2);

        Order order2 = masterorderlist.newOrder(customerprofile3, salespersonprofile_2);
        OrderItem oi2_1 = order2.newOrderItem(products1p1, 12000, 1);
        OrderItem oi2_2 = order2.newOrderItem(products1p2, 18500, 2);
        OrderItem oi2_3 = order2.newOrderItem(products1p3, 36500, 4);
        OrderItem oi2_4 = order2.newOrderItem(products1p4, 30000, 2);
        OrderItem oi2_5 = order2.newOrderItem(products1p5, 26000, 5);
        OrderItem oi2_6 = order2.newOrderItem(products1p6, 95000, 1);
        OrderItem oi2_7 = order2.newOrderItem(products1p7, 26500, 2);
        OrderItem oi2_8 = order2.newOrderItem(products1p8, 40000, 5);

        Order order3 = masterorderlist.newOrder(customerprofile4, salespersonprofile_1);
        OrderItem oi3_1 = order3.newOrderItem(products2p1, 18500, 1);
        OrderItem oi3_2 = order3.newOrderItem(products2p2, 10500, 2);
        OrderItem oi3_3 = order3.newOrderItem(products2p3, 48500, 10);
        OrderItem oi3_4 = order3.newOrderItem(products2p4, 40000, 1);
        OrderItem oi3_5 = order3.newOrderItem(products2p5, 35000, 3);
        OrderItem oi3_6 = order3.newOrderItem(products2p6, 15000, 2);
        OrderItem oi3_7 = order3.newOrderItem(products2p7, 36500, 3);
        OrderItem oi3_8 = order3.newOrderItem(products2p8, 40000, 1);

        Order order4 = masterorderlist.newOrder(customerprofile2, salespersonprofile_2);
        OrderItem oi4_1 = order4.newOrderItem(products2p1, 19500, 1);
        OrderItem oi4_2 = order4.newOrderItem(products2p2, 10500, 2);
        OrderItem oi4_3 = order4.newOrderItem(products2p3, 48500, 10);
        OrderItem oi4_4 = order4.newOrderItem(products2p4, 40000, 1);
        OrderItem oi4_5 = order4.newOrderItem(products2p5, 37000, 3);
        OrderItem oi4_6 = order4.newOrderItem(products2p6, 15000, 2);
        OrderItem oi4_7 = order4.newOrderItem(products2p7, 36500, 3);
        OrderItem oi4_8 = order4.newOrderItem(products2p8, 35000, 1);

        ProductSummary ps = new ProductSummary(products1p8);

        MarketCatalog mc = business.getMarketCatalog();
        ChannelCatalog channelCatalog = business.getChannelCatalog();

        //START : Define market and channel combinations
        Market teenmarket = mc.newMarket("Teenagers");
        Market teenmarket2 = mc.newMarket("College Grads");

        Channel tvchannel = channelCatalog.newChannel("tv");
        Channel webchannel = channelCatalog.newChannel("web");

        teenmarket.addValidChannel(webchannel);
        teenmarket.addValidChannel(tvchannel);

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();

        MarketChannelAssignment tvchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, tvchannel);
        MarketChannelAssignment webchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, webchannel);
        //END : Define market and channel combinations

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();

        SolutionOffer solutiontvteen_p1 = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen_p1.setProductPriceDetails(products1p1, 2000, 15000, 9000);
        SolutionOffer solutiontvteen_p2 = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen_p2.setProductPriceDetails(products1p2, 10000, 20000, 15000);
        SolutionOffer solutiontvteen_p3 = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen_p3.setProductPriceDetails(products1p3, 22000, 35000, 32000);
        SolutionOffer solutiontvteen_p4 = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen_p4.setProductPriceDetails(products1p4, 30000, 50000, 35000);

        SolutionOffer solutionwebteen_p1 = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen_p1.setProductPriceDetails(products2p1, 10000, 25000, 15000);
        SolutionOffer solutionwebteen_p2 = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen_p2.setProductPriceDetails(products2p2, 9000, 20000, 11000);
        SolutionOffer solutionwebteen_p3 = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen_p3.setProductPriceDetails(products2p3, 40000, 60000, 40000);
        SolutionOffer solutionwebteen_p4 = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen_p4.setProductPriceDetails(products2p4, 40000, 70000, 45000);

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
        SolutionOrder so_1 = msol.newSolutionOrder(solutiontvteen_p1, tvchannelteenmarket);
        SolutionOrder so_2 = msol.newSolutionOrder(solutiontvteen_p2, tvchannelteenmarket);
        SolutionOrder so_3 = msol.newSolutionOrder(solutiontvteen_p3, tvchannelteenmarket);
        SolutionOrder so_4 = msol.newSolutionOrder(solutiontvteen_p4, tvchannelteenmarket);
        SolutionOrder so_5 = msol.newSolutionOrder(solutionwebteen_p1, webchannelteenmarket);
        SolutionOrder so_6 = msol.newSolutionOrder(solutionwebteen_p2, webchannelteenmarket);
        SolutionOrder so_7 = msol.newSolutionOrder(solutionwebteen_p3, webchannelteenmarket);
        SolutionOrder so_8 = msol.newSolutionOrder(solutionwebteen_p4, webchannelteenmarket);
//
//        msol.getRevenueByMarketChannelCombo(tvchannelteenmarket);
//        msol.getRevenueByChannel(tvchannel);

        return business;

    }

    static Business initializeMarkets() {
        Business business = new Business("Xerox");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");

// Create Customers
        CustomerDirectory customedirectory = business.getCustomerDirectory();
        CustomerProfile customerprofile1
                = customedirectory.newCustomerProfile(xeroxsalesperson001);

// Create Sales people
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

        // Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

        SupplierDirectory suplierdirectory = business.getSupplierDirectory();

        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
        ProductCatalog productcatalog = supplier1.getProductCatalog();
        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);

        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
        productcatalog = supplier2.getProductCatalog();
        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
        Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
        Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

//=============== Define markets and channels...
        MarketCatalog mc = business.getMarketCatalog();
        Market teenmarket = mc.newMarket("Teenagers");
        Market teenmarket2 = mc.newMarket("College Grads");

        ChannelCatalog channelCatalog = business.getChannelCatalog();

        Channel tvchannel = channelCatalog.newChannel("tv");
        Channel webchannel = channelCatalog.newChannel("web");

        teenmarket.addValidChannel(webchannel);
        teenmarket.addValidChannel(tvchannel);

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();

        MarketChannelAssignment tvchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, tvchannel);
        MarketChannelAssignment webchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, webchannel);

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();

        SolutionOffer solutiontvteen = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen.addProduct(products2p2);
        solutiontvteen.addProduct(products2p1);
        solutiontvteen.setTotalPrice(1000);

        SolutionOffer solutionwebteen = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen.addProduct(products2p2);
        solutionwebteen.addProduct(products2p1);
        solutionwebteen.setTotalPrice(500);

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();

        SolutionOrder so = msol.newSolutionOrder(solutiontvteen, tvchannelteenmarket);

        SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen, webchannelteenmarket);

        msol.getRevenueByMarketChannelCombo(tvchannelteenmarket);
        msol.getRevenueByChannel(tvchannel);

        return business;

    }

}
