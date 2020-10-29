package com.example.ecommercedemo.models;

public class CartItemModel {

    /////Cart Item
    private int cartItemImageResource;
    private String cartItemTitle;
    private String cartItemPrice;
    private String cartItemCuttedPrice;
    private int itemQuantity;

    public CartItemModel(int cartItemImageResource, String cartItemTitle, String cartItemPrice,
                         String cartItemCuttedPrice, int itemQuantity) {
        this.cartItemImageResource = cartItemImageResource;
        this.cartItemTitle = cartItemTitle;
        this.cartItemPrice = cartItemPrice;
        this.cartItemCuttedPrice = cartItemCuttedPrice;
        this.itemQuantity = itemQuantity;
    }

    public int getCartItemImageResource() {
        return cartItemImageResource;
    }

    public void setCartItemImageResource(int cartItemImageResource) {
        this.cartItemImageResource = cartItemImageResource;
    }

    public String getCartItemTitle() {
        return cartItemTitle;
    }

    public void setCartItemTitle(String cartItemTitle) {
        this.cartItemTitle = cartItemTitle;
    }

    public String getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(String cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }

    public String getCartItemCuttedPrice() {
        return cartItemCuttedPrice;
    }

    public void setCartItemCuttedPrice(String cartItemCuttedPrice) {
        this.cartItemCuttedPrice = cartItemCuttedPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    /////Cart Item
}
