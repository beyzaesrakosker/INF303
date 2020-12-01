package com.example.inf303;

public class Kullaniciekle {


    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    private String Ad;

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    private String Soyad;


    public Kullaniciekle(String ad, String soyad) {
        Ad = ad;
        Soyad = soyad;
    }
}

