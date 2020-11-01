package com.example.ecommercedemo.models;

public class MyOrderItemModel {
    private int myOrderItemImage;
    private int myOrderItemRating;
    private String myOrderItemTitle;
    private String myOrderItemDeliveryStatus;

    public MyOrderItemModel(int myOrderItemImage, int myOrderItemRating, String myOrderItemTitle, String myOrderItemDeliveryStatus) {
        this.myOrderItemImage = myOrderItemImage;
        this.myOrderItemRating = myOrderItemRating;
        this.myOrderItemTitle = myOrderItemTitle;
        this.myOrderItemDeliveryStatus = myOrderItemDeliveryStatus;
    }

    public int getMyOrderItemImage() {
        return myOrderItemImage;
    }

    public void setMyOrderItemImage(int myOrderItemImage) {
        this.myOrderItemImage = myOrderItemImage;
    }

    public String getMyOrderItemTitle() {
        return myOrderItemTitle;
    }

    public void setMyOrderItemTitle(String myOrderItemTitle) {
        this.myOrderItemTitle = myOrderItemTitle;
    }

    public String getMyOrderItemDeliveryStatus() {
        return myOrderItemDeliveryStatus;
    }

    public void setMyOrderItemDeliveryStatus(String myOrderItemDeliveryStatus) {
        this.myOrderItemDeliveryStatus = myOrderItemDeliveryStatus;
    }

    public int getMyOrderItemRating() {
        return myOrderItemRating;
    }

    public void setMyOrderItemRating(int myOrderItemRating) {
        this.myOrderItemRating = myOrderItemRating;
    }
}
