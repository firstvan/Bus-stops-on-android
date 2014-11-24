package com.example.firstvan.busstop;

/**
 * Created by firstvan on 23/11/14.
 */
public class Megallok {
    private String jarat;
    private String name;
    private double lat;
    private double lng;


    public Megallok(String j, String a, double rlat, double rlng)
    {
        jarat = j;
        name = a;
        lat = rlat;
        lng = rlng;
    }

    public void setJarat(String a){
        jarat = a;
    }

    public void setName(String a){
        name = a;
    }

    public void setLat(double a){
        lat = a;
    }

    public void setLng(double a){
        lng = a;
    }

    public String getJarat(){
        return jarat;
    }

    public String getName(){
        return name;
    }

    public double getLat(){
        return lat;
    }

    public double getLng(){
        return lng;
    }
}


