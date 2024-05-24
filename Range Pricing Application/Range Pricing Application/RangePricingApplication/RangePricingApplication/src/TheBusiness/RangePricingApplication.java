/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness;

import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Business business = ConfigureABusiness.initialize();
        List<Supplier> supplierList = business.getSupplierDirectory().getSuplierList();

        System.out.println("RangePricingApplication Run : ");
        System.out.println("Business Detail :" + business.getName());
        System.out.println("Supplier Detail(s) :");
        System.out.println("Number of Suppliers under Business :" + business.getName()
                + " - "
                + business.getSupplierDirectory().getSuplierList().size()
        );
        System.out.println(" ---------------------------------------------------------------");
        for (Supplier sup : supplierList) {
            System.out.println("______________________________________________________________");
            System.out.println("Supplier Name :" + sup.getName());
            System.out.println("______________________________________________________________");
            System.out.println("Supplier Product Detail(s) :");
            for (Product prd : sup.getProductCatalog().getProductList()) {
                String sbf = new String().concat("Product Name :")
                        .concat(prd.getName())
                        .concat(", Ceilng Price :")
                        .concat(prd.getCeilingPrice() + "")
                        .concat(", Floor Price :")
                        .concat(prd.getFloorPrice() + "")
                        .concat(", Target Price :")
                        .concat(prd.getTargetPrice() + "");

                System.out.println(sbf);
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Registered Customer Detail(s) :");
        System.out.println("---------------------------------------------------------------");

        for (CustomerProfile cp : business.getCustomerDirectory().getCustomerlist()) {
            System.out.println("Customer Name :" + cp.getCustomerId());
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Customer Order Detail(s) :");
        System.out.println("---------------------------------------------------------------");

        MasterOrderList masterorderlist = business.getMasterOrderList();
        for (Order ord : masterorderlist.getOrders()) {
            if (!ord.getOrderitems().isEmpty()) {
                System.out.println("______________________________________________________________");
                System.out.println("Customer Name :" + ord.getCustomer().getCustomerId());
                System.out.println("Sales Person Name :" + ord.getSalesperson().getPerson().getPersonId());
                System.out.println("______________________________________________________________");

                String headerv = new String().concat("Product Name |")
                        .concat("Ceilng Price   |")
                        .concat("Floor Price    |")
                        .concat("Target Price   |")
                        .concat("Order Price    |")
                        .concat("Quantity       |")
                        .concat("Total Product Price |")
                        .concat("Total Order Price |")
                        .concat("Price Performance  ");
                System.out.println(headerv);
                for (OrderItem ordItm : ord.getOrderitems()) {
                    String pricePerf = "";
                    if (ordItm.isActualAboveTarget()) {
                        pricePerf = "Above Target";
                    } else if (ordItm.isActualBelowTarget()) {
                        pricePerf = "Below Target";
                    } else if (ordItm.isActualATTarget()) {
                        pricePerf = "At Target";
                    }
                    String dataerv = new String()
                            .concat(ordItm.getSelectedProduct().getName() + "\t")
                            .concat(ordItm.getSelectedProduct().getCeilingPrice() + "\t")
                            .concat(ordItm.getSelectedProduct().getFloorPrice() + "\t")
                            .concat(ordItm.getSelectedProduct().getTargetPrice() + "\t")
                            .concat(ordItm.getActualPrice() + "\t")
                            .concat(ordItm.getQuantity() + " \t")
                            .concat(ordItm.getOrderItemTargetTotal() + " \t")
                            .concat(ordItm.getOrderItemTotal() + " \t")
                            .concat(ordItm.calculatePricePerformance() + "-" + pricePerf);
                    System.out.println(dataerv);
                }
            }
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Top 3 Customer Details Based on the total products above target price  :");
        System.out.println("-------------------------------------------------------------------------");
        Map<Integer, String> orderMap = new TreeMap<>(Collections.reverseOrder());
        for (Order ord : masterorderlist.getOrders()) {
            if (!ord.getOrderitems().isEmpty()) {
                orderMap.put(ord.getNumberOfOrderItemsAboveTarget(),
                        ord.getCustomer().getCustomerId());
            }
        }

        Set set2 = orderMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();
            System.out.println("Customer Name :" + me2.getValue());
            System.out.println("Orders Above Target :" + me2.getKey());
            System.out.println("");
        }
        System.out.println("______________________________________________________________");

        System.out.println("---------------------------------------------------------------");
        System.out.println("Product Summary Detail(s) By Supplier and Product :");
        System.out.println("---------------------------------------------------------------");
        for (Supplier sup : supplierList) {
            for (Product prd : sup.getProductCatalog().getProductList()) {
                ProductSummary ps = new ProductSummary(prd);
                String sbf = new String()
                        .concat("Supplier Name :")
                        .concat(sup.getName())
                        .concat(", Product Name :")
                        .concat(prd.getName())
                        .concat(", Sales Volume :")
                        .concat(ps.getSalesRevenues() + "")
                        .concat(", Profit Margin :")
                        .concat(ps.getProductPricePerformance() + "")
                        .concat(", Frequency above target :")
                        .concat(ps.getNumberAboveTarget() + "")
                        .concat(", Frequency Below :")
                        .concat(ps.getNumberBelowTarget() + "");

                System.out.println(sbf);
            }
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Top 3 Sales Person Details Based on the products above target price  :");
        System.out.println("-------------------------------------------------------------------------");
        Map<Integer, String> salesMap = new TreeMap<>(Collections.reverseOrder());
        for (Order ord : masterorderlist.getOrders()) {
            if (!ord.getOrderitems().isEmpty()) {
                salesMap.put(ord.getNumberOfOrderItemsAboveTarget(),
                        ord.getSalesperson().getPerson().getPersonId());
            }
        }

        Set set3 = salesMap.entrySet();
        Iterator iterator3 = set3.iterator();
        while (iterator3.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator3.next();
            System.out.println("Sales Person Name :" + me2.getValue());
            System.out.println("Orders Above Target :" + me2.getKey());
            System.out.println("");
        }
        System.out.println("______________________________________________________________");

        System.out.println("---------------------------------------------------------------");
        System.out.println("Market Analysys :");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Market & Channel Details :");
        System.out.println("---------------------------------------------------------------");

        MarketCatalog mc = business.getMarketCatalog();
        for (Market ma : mc.getMarkets()) {
            for (Channel ch : ma.getValidchannels()) {
                String sbf = new String()
                        .concat("Market Name :")
                        .concat(ma.getName())
                        .concat(", Channel Name :")
                        .concat(ch.getChannelType());

                System.out.println(sbf);
            }
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Market Solutions Offered to Markets:");
        System.out.println("---------------------------------------------------------------");
        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
        SolutionOfferCatalog solOffCat = business.getSolutionOfferCatalog();
        for (MarketChannelAssignment mca : mccc.getMcalist()) {
            ArrayList<SolutionOffer> foundsolutions
                    = solOffCat.findSolutionsForMarketChannelCombo(mca);
            for (SolutionOffer so : foundsolutions) {
                String sbf = new String();
                sbf = sbf.concat("Solution Offered to Market :")
                        .concat("\n").concat("Market :")
                        .concat(so.getMarketchannelcomb().getMarket().getName())
                        .concat("\n")
                        .concat("Channel :")
                        .concat(so.getMarketchannelcomb().getChannel().getChannelType())
                        .concat("\n")
                        .concat("Product : ")
                        .concat(so.getProduct().getName() + ",")
                        .concat("\n")
                        .concat("Solution Offer : Ceiling :" + so.getSoCP() + ",")
                        .concat("Solution Offer : Floor :" + so.getSoFP() + ",")
                        .concat("Solution Offer : Target :" + so.getSoTP() + "")
                        .concat("");

                System.out.println(sbf);
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Orders placed for Solutions Offered to Markets:");
        System.out.println("---------------------------------------------------------------");

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
        for (SolutionOrder so : msol.getSolutionorderlist()) {
            String sbf = new String();
            sbf = sbf.concat("Solution Order Placed to Market :")
                    .concat("\n")
                    .concat("Product : ")
                    .concat(so.getSelectedsolutionoffer().getProduct().getName())
                    .concat("\n")
                    .concat("Ceiling :" + so.getSelectedsolutionoffer().getProduct().getCeilingPrice() + ",")
                    .concat("Floor :" + so.getSelectedsolutionoffer().getProduct().getFloorPrice() + ",")
                    .concat("Target :" + so.getSelectedsolutionoffer().getProduct().getTargetPrice() + ",")
                    .concat("\n")
                    .concat("Solution Offer - Ceiling :" + so.getSelectedsolutionoffer().getSoCP() + ",")
                    .concat("Solution Offer - Floor :" + so.getSelectedsolutionoffer().getSoFP() + ",")
                    .concat("Solution Offer - Target :" + so.getSelectedsolutionoffer().getSoTP() + "")
                    .concat("\n")
                    .concat("");

            System.out.println(sbf);
        }

        for (MarketChannelAssignment mca : mccc.getMcalist()) {

            String sbf = new String();
            sbf = sbf.concat("Revenue Generated by the Market with Solutions Offered : \n")
                    .concat("Market - ")
                    .concat(mca.getMarket().getName()).concat("\n")
                    .concat("Channel -  ")
                    .concat(mca.getChannel().getChannelType()).concat("\n")
                    .concat("Revenue Generated -  ")
                    .concat(msol.getRevenueByMarketChannelCombo(mca) + "")
                    .concat("\n")
                    .concat("");
            System.out.println(sbf);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
    }

}
