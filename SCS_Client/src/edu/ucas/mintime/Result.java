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
public class Result implements Cloneable{
    public  ArrayList<Station> stationList = new ArrayList<Station>();
    public  int totalTime;
    public  double distance;
    public  Station station;
    public  String curLine;
    public  int changes;
    public  boolean checked = false;
    public  ArrayList<String> tranLines = new ArrayList<String>();
    public  ArrayList<String> tranStations = new ArrayList<String>();
    
    public Object clone(){
        Object o = null;
        try{
            o = (Result)super.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }
    
}
