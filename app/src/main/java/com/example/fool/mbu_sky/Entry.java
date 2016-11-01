package com.example.fool.mbu_sky;

import java.util.Date;

/**
 * Created by fool on 10/30/16.
 */


public class Entry{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private double lat, lng;
    private Date date;
    Layer layer1, layer2;

    public Entry() {
    }

    public Entry(String title, double lat, double lng, Date date, Layer layer1, Layer layer2) {
        this.title=title;
        this.lat = lat;
        this.lng = lng;
        this.date = date;
        this.layer1 = layer1;
        this.layer2 = layer2;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Layer getLayer1() {
        return layer1;
    }

    public void setLayer1(Layer layer1) {
        this.layer1 = layer1;
    }

    public Layer getLayer2() {
        return layer2;
    }

    public void setLayer2(Layer layer2) {
        this.layer2 = layer2;
    }
}
