package com.example.c15347186.e_commerce_app.items;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Item {

    public String title;
    public String manufacturer;
    public String price;
    public String category;

    public Item(){

    }

    public Item(String title, String manufacturer, String price, String category) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
    }


}
