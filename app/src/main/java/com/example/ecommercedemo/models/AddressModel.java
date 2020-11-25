package com.example.ecommercedemo.models;

import android.widget.ImageView;

public class AddressModel {
    private String fullName;
    private String address;
    private String pinCode;
    private boolean isAddressSelected;

    public AddressModel(String fullName, String address, String pinCode, boolean isAddressSelected) {
        this.fullName = fullName;
        this.address = address;
        this.pinCode = pinCode;
        this.isAddressSelected = isAddressSelected;
    }

    public boolean isAddressSelected() {
        return isAddressSelected;
    }

    public void setAddressSelected(boolean addressSelected) {
        isAddressSelected = addressSelected;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
