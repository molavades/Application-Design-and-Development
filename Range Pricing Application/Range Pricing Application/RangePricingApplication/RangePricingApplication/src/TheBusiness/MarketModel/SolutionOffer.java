/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {

    private ArrayList<Product> products;
    private Product product;
    private int price;//floor, ceiling, and target ideas
    private int soFP;
    private int soCP;
    private int soTP;
    String ad;
    private MarketChannelAssignment marketchannelcomb;
    private ArrayList<SolutionOrder> solutionorders;

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the marketchannelcomb
     */
    public MarketChannelAssignment getMarketchannelcomb() {
        return marketchannelcomb;
    }

    /**
     * @return the solutionorders
     */
    public ArrayList<SolutionOrder> getSolutionorders() {
        return solutionorders;
    }

    public SolutionOffer(MarketChannelAssignment m) {
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this);

    }

    public void addProduct(Product p) {
        getProducts().add(p);
    }

    public void setTotalPrice(int p) {
        price = p;

    }

    public void setProductPriceDetails(Product prd, int fp, int cp, int tp) {
        product = prd;
        soFP = fp;
        soCP = cp;
        soTP = tp;

    }

    public int getSolutionPrice() {
        return getPrice();
    }

    public int getRevenues() {
        int sum = 0;
        for (SolutionOrder so : getSolutionorders()) {
            sum = sum + so.getSolutionPrice();
        }
        return sum;
    }

    public void addSolutionOrder(SolutionOrder so) {
        getSolutionorders().add(so);
    }

    // this will allow one to retrieve all offers meant for this market/channel combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca) {

        if (getMarketchannelcomb() == mca) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the soFP
     */
    public int getSoFP() {
        return soFP;
    }

    /**
     * @return the soCP
     */
    public int getSoCP() {
        return soCP;
    }

    /**
     * @return the soTP
     */
    public int getSoTP() {
        return soTP;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String a) { //this an amazing solution for people like
        ad = a;
    }

}
