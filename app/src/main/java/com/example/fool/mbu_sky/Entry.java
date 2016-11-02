package com.example.fool.mbu_sky;

import android.app.LauncherActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;

import java.util.Date;

/**
 * Created by fool on 10/30/16.
 */


public class Entry {

    private String title;
    private double lat, lng;
    private Date date;
    Layer layer1, layer2;

    SQLiteDatabase mydb;
    ContentValues contentValues;
    DatabaseHelper entry_db;
    public Entry() {
    }

    public Entry(Context context, String title, double lat, double lng, double Vp1, double Vs1, double h1, double p1, double Vp2, double Vs2, double h2, double p2) {
        this.title=title;
        this.lat = lat;
        this.lng = lng;
        this.layer1 = new Layer(Vp1, Vs1, h1, p1);
        this.layer2 = new Layer(Vp2, Vs2, h2, p2);

        entry_db = new DatabaseHelper(context);
        mydb = entry_db.getWritableDatabase();
        this.contentValues = new ContentValues();
        String s= "TITLE TEXT, LAT TEXT, LNG TEXT," +
        " VP1 FLOAT, VS1 FLOAT, H1 FLOAT, P1 FLOAT," +
                " DENS1 FLOAT, GMAX1 FLOAT, E1 FLOAT, V1 FLOAT, K1 FLOAT, T1 FLOAT, Z1 FLOAT" +
                ", VP2 FLOAT,  VS2 FLOAT, H2 FLOAT, P2 FLOAT," +
                " DENS2 FLOAT, GMAX2 FLOAT, E2 FLOAT, V1 FLOAT, K2 FLOAT, T2 FLOAT, Z2 FLOAT";



    }

    public long save(){
        try {

            layer1.hesap(layer2.getVs());
            layer2.hesap();
            contentValues.put("TITLE", title);
            contentValues.put("LAT", lat);
            contentValues.put("LNG", lng);
            contentValues.put("VP1", layer1.getVp());
            contentValues.put("VS1", layer1.getVs());
            contentValues.put("H1", layer1.getH());
            contentValues.put("P1", layer1.getP());
            contentValues.put("DENS1", layer1.getYogunluk());
            contentValues.put("GMAX1", layer1.getGmax());
            contentValues.put("E1", layer1.getE());
            contentValues.put("V1", layer1.getV());
            contentValues.put("K1", layer1.getK());
            contentValues.put("T1", layer1.getT());
            contentValues.put("Z1", layer1.getZ());
            contentValues.put("VP2", layer2.getVp());
            contentValues.put("VS2", layer2.getVs());
            contentValues.put("H2", layer2.getH());
            contentValues.put("P2", layer2.getP());
            contentValues.put("DENS2", layer2.getYogunluk());
            contentValues.put("GMAX2", layer2.getGmax());
            contentValues.put("E2", layer2.getE());
            contentValues.put("V2", layer2.getV());
            contentValues.put("K2", layer2.getK());
            contentValues.put("Z2", layer2.getZ());
            return mydb.insert("entries",null, contentValues);

        }catch (Exception e){
            System.out.println(e);
            return -1;
        }

    }
    public Entry get(long id){
        Cursor c = mydb.rawQuery("select * from entries where id="+String.valueOf(id),null);
        if(c.moveToFirst()){
            return new Entry(); //fill
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", date=" + date +
                ", layer1=" + layer1 +
                ", layer2=" + layer2 +
                '}';
    }
}
