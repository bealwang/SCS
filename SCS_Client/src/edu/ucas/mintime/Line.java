/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.mintime;

import java.util.ArrayList;

/**
 *
 * @author huipu
 */
public class Line {
    private String lineName;
    private ArrayList<String> stations;

    /**
     * @return the lineName
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * @param lineName the lineName to set
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * @return the stations
     */
    public ArrayList<String> getStations() {
        return stations;
    }

    /**
     * @param stations the stations to set
     */
    public void setStations(ArrayList<String> stations) {
        this.stations = stations;
    }
    
}
