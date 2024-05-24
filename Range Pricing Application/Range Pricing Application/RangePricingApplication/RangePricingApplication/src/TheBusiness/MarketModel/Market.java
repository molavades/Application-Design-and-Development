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
public class Market {

    private String name;
    private ArrayList<Channel> validchannels;
    private ArrayList<String> characteristics; //a way to describe in plain language what is that group
    private ArrayList<Market> submarkets;
    private int size;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the validchannels
     */
    public ArrayList<Channel> getValidchannels() {
        return validchannels;
    }

    /**
     * @return the characteristics
     */
    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    /**
     * @return the submarkets
     */
    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    public Market(String m) {
        name = m;
        characteristics = new ArrayList();
        submarkets = new ArrayList();
        validchannels = new ArrayList();
    }

    public void addCharactersitic(String c) {
        getCharacteristics().add(c);
    }

    public void addValidChannel(Channel c) {

        getValidchannels().add(c);
    }

}
