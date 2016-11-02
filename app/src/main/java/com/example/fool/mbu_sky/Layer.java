package com.example.fool.mbu_sky;

/**
 * Created by fool on 10/30/16.
 */


public class Layer {
    /*
    *
    * Vp -> Sıkışma dalga hızı
    * Vs -> Kayma dalga hızı
    * h -> Tabaka kalınlıkları
    * p -> Özdirenç değerleri
    *
    */
    private double Vs;
    private double Vp;
    private double h;
    private double p;
    private double yogunluk;
    private double Gmax;
    private double E;
    private double V;

    public double getV() {
        return V;
    }

    public void setV(double v) {
        V = v;
    }

    private double K;
    private double T=0;
    private double Z;

    public Layer() {
    }

    public Layer(double vp, double vs, double h, double p) {
        this.Vs = vs;
        this.Vp = vp;
        this.h = h;
        this.p = p;
    }

    public void hesap(double Vs2){
        this.yogunluk = (0.76)*Math.pow(Vp, (0.074))*Math.pow(Vs, (0.074));
        this.Gmax = yogunluk*Math.sqrt(Vs)/100;
        this.E = (3*Gmax)*(Math.sqrt((Vp/Vs))-(4/3)/(Math.sqrt((Vp/Vs))-1));
        this.V=(Math.sqrt((Vp/Vs))-1)/(2*Math.sqrt((Vp/Vs))-2);
        this.K = Gmax*(Math.sqrt((Vp/Vs))-(4/3));
        this.T = 4*(h/Vs)+4*(50-h)/Vs2;
        this.Z = 1.67*Math.log((2.7*2500)/(yogunluk*Vs));
    }

    public void hesap(){
        this.yogunluk = (0.76)*Math.pow(Vp, (0.074))*Math.pow(Vs, (0.074));
        this.Gmax = yogunluk*Math.sqrt(Vs)/100;
        this.E = (3*Gmax)*(Math.sqrt((Vp/Vs))-(4/3)/(Math.sqrt((Vp/Vs))-1));
        this.V=(Math.sqrt((Vp/Vs))-1)/(2*Math.sqrt((Vp/Vs))-2);
        this.K = Gmax*(Math.sqrt((Vp/Vs))-(4/3));
        this.Z = 1.67*Math.log((2.7*2500)/(yogunluk*Vs));
    }

    public double getVs() {
        return Vs;
    }

    public void setVs(double vs) {
        Vs = vs;
    }

    public double getVp() {
        return Vp;
    }

    public void setVp(double vp) {
        Vp = vp;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getYogunluk() {
        return yogunluk;
    }

    public void setYogunluk(double yogunluk) {
        this.yogunluk = yogunluk;
    }

    public double getGmax() {
        return Gmax;
    }

    public void setGmax(double gmax) {
        Gmax = gmax;
    }

    public double getE() {
        return E;
    }

    public void setE(double e) {
        E = e;
    }

    public double getK() {
        return K;
    }

    public void setK(double k) {
        K = k;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    @Override
    public String toString() {
        return "Layer{" +
                "Vs=" + Vs +
                ", Vp=" + Vp +
                ", h=" + h +
                ", p=" + p +
                ", yogunluk=" + yogunluk +
                ", Gmax=" + Gmax +
                ", E=" + E +
                ", K=" + K +
                ", T=" + T +
                ", Z=" + Z +
                ", V=" + V +
                '}';
    }
}
