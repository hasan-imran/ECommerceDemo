package com.example.ecommercedemo.models;

public class HorizontalScrollItemModel {
    private int horizontalScrollItemImageLink;
    private String horizontalScrollItemTitle, horizontalScrollItemSubTitle, horizontalScrollItemPrice;

    public HorizontalScrollItemModel(int horizontalScrollItemImageLink, String horizontalScrollItemTitle, String horizontalScrollItemSubTitle, String horizontalScrollItemPrice) {
        this.horizontalScrollItemImageLink = horizontalScrollItemImageLink;
        this.horizontalScrollItemTitle = horizontalScrollItemTitle;
        this.horizontalScrollItemSubTitle = horizontalScrollItemSubTitle;
        this.horizontalScrollItemPrice = horizontalScrollItemPrice;
    }

    public int getHorizontalScrollItemImageLink() {
        return horizontalScrollItemImageLink;
    }

    public void setHorizontalScrollItemImageLink(int horizontalScrollItemImageLink) {
        this.horizontalScrollItemImageLink = horizontalScrollItemImageLink;
    }

    public String getHorizontalScrollItemTitle() {
        return horizontalScrollItemTitle;
    }

    public void setHorizontalScrollItemTitle(String horizontalScrollItemTitle) {
        this.horizontalScrollItemTitle = horizontalScrollItemTitle;
    }

    public String getHorizontalScrollItemSubTitle() {
        return horizontalScrollItemSubTitle;
    }

    public void setHorizontalScrollItemSubTitle(String horizontalScrollItemSubTitle) {
        this.horizontalScrollItemSubTitle = horizontalScrollItemSubTitle;
    }

    public String getHorizontalScrollItemPrice() {
        return horizontalScrollItemPrice;
    }

    public void setHorizontalScrollItemPrice(String horizontalScrollItemPrice) {
        this.horizontalScrollItemPrice = horizontalScrollItemPrice;
    }
}
