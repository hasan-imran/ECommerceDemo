package com.example.ecommercedemo.models;

public class WishlistItemModel {
    private int itemImageResource;
    private String itemTitle;
    private String itemRating;
    private String itemTotalRatings;
    private String itemPrice;
    private String itemCuttedPrice;

    public WishlistItemModel(int itemImageResource, String itemTitle,
                             String itemRating, String itemTotalRatings, String itemPrice, String itemCuttedPrice) {
        this.itemImageResource = itemImageResource;
        this.itemTitle = itemTitle;
        this.itemRating = itemRating;
        this.itemTotalRatings = itemTotalRatings;
        this.itemPrice = itemPrice;
        this.itemCuttedPrice = itemCuttedPrice;
    }

    public int getItemImageResource() {
        return itemImageResource;
    }

    public void setItemImageResource(int itemImageResource) {
        this.itemImageResource = itemImageResource;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemRating() {
        return itemRating;
    }

    public void setItemRating(String itemRating) {
        this.itemRating = itemRating;
    }

    public String getItemTotalRatings() {
        return itemTotalRatings;
    }

    public void setItemTotalRatings(String itemTotalRatings) {
        this.itemTotalRatings = itemTotalRatings;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCuttedPrice() {
        return itemCuttedPrice;
    }

    public void setItemCuttedPrice(String itemCuttedPrice) {
        this.itemCuttedPrice = itemCuttedPrice;
    }
}
