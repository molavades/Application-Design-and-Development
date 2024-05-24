/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {

    private ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        solutionoffers = new ArrayList();
    }

    /**
     * @return the solutionoffers
     */
    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }

    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca) {

        SolutionOffer so = new SolutionOffer(mca);
        getSolutionoffers().add(so);

        return so;
    }

    //return all solution offers that match m/c combination
    public ArrayList<SolutionOffer> findSolutionsForMarketChannelCombo(MarketChannelAssignment mcc) {
        ArrayList<SolutionOffer> foundsolutions = new ArrayList();

        for (SolutionOffer so : getSolutionoffers()) {

            if (so.isSolutionOfferMatchMarketChannel(mcc) == true) {
                foundsolutions.add(so);
            }
            //find all solution offers available in the market/channel combin
        }
        return foundsolutions;

    }

}
