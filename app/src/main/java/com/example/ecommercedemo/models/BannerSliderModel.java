package com.example.ecommercedemo.models;

public class BannerSliderModel {
    private int bannerId;
    private String backgroundColor;

    public BannerSliderModel(int bannerId, String backgroundColor) {
        this.bannerId = bannerId;
        this.backgroundColor = backgroundColor;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
