package com.example.c15347186.e_commerce_app.payment;

public class Cash implements PaymentMethod {
    @Override
    public void pay(int cents) {
        System.out.println("Payed " + cents + " cents using cash");
    }
}
