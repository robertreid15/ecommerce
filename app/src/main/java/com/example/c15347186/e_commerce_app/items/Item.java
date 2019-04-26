package com.example.c15347186.e_commerce_app.items;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Item {

    //public String itemId;
    public String title;
    public String manufacturer;
    public String price;
    public String category;

    public Item(){

    }

    public Item(String title, String manufacturer, String price, String category) {
        //this.itemId = itemId;
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
    }

    /*public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
