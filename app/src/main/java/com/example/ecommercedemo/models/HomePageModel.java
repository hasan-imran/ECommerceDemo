package com.example.ecommercedemo.models;

import java.util.List;

public class HomePageModel {

    public static final int BANNER_SLIDER_ID = 0;
    public static final int ADVERTISEMENT_ID = 1;
    public static final int HORIZONTAL_ITEM_VIEW_ID = 2;
    public static final int GRID_ITEM_VIEW_ID = 3;

    private int type;

    ///Banner Slider
    private List<BannerSliderModel> banners;

    public HomePageModel(int type, List<BannerSliderModel> banners) {
        this.type = type;
        this.banners = banners;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<BannerSliderModel> getBanners() {
        return banners;
    }
    public void setBanners(List<BannerSliderModel> banners) {
        this.banners = banners;
    }
    ///Banner Slider


    ///Advertisement
    private int imageResource;
    private String backgroundColor;

    public HomePageModel(int type, int imageResource, String backgroundColor) {
        this.type = type;
        this.imageResource = imageResource;
        this.backgroundColor = backgroundColor;
    }
    public int getImageResource() {
        return imageResource;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    ///Advertisement


    ///Horizontal Products && Grid Products
    private String title;
    private List<HorizontalScrollItemModel> items;

    public HomePageModel(int type, String title, List<HorizontalScrollItemModel> items) {
        this.type = type;
        this.title = title;
        this.items = items;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<HorizontalScrollItemModel> getItems() {
        return items;
    }
    public void setItems(List<HorizontalScrollItemModel> items) {
        this.items = items;
    }
    ///Horizontal Products && Grid Products

}
