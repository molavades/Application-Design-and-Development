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
public class MarketChannelComboCatalog {

    /**
     * @return the mcalist
     */
    public ArrayList<MarketChannelAssignment> getMcalist() {
        return mcalist;
    }
    
    private ArrayList<MarketChannelAssignment> mcalist ;
    
   public MarketChannelComboCatalog() {
       
       mcalist = new ArrayList();
       
   }
   
   public MarketChannelAssignment newMarketChannelCombo(Market m, Channel c){
       MarketChannelAssignment mcc = new MarketChannelAssignment(m, c);
        getMcalist().add(mcc);
       return mcc;
       
   }
   public MarketChannelAssignment finMarketChannelCombo(Market m, Channel c){
       
       for( MarketChannelAssignment mca: getMcalist()){
           if(mca.matches(m,c)) return mca;
       }
       return null;
       
   }
}
