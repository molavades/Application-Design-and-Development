/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class SolutionOrder {

    /**
     * @return the selectedsolutionoffer
     */
    public SolutionOffer getSelectedsolutionoffer() {
        return selectedsolutionoffer;
    }

    /**
     * @return the marketChannelAssignment
     */
    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelAssignment;
    }

    private SolutionOffer selectedsolutionoffer;
    private MarketChannelAssignment marketChannelAssignment;

    public SolutionOrder(SolutionOffer so, MarketChannelAssignment mca) {
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;

    }

    public int getSolutionPrice() {
        return getSelectedsolutionoffer().getSolutionPrice();
    }

    public MarketChannelAssignment getMarketChannelCombo() {

        return getMarketChannelAssignment();

    }

}
