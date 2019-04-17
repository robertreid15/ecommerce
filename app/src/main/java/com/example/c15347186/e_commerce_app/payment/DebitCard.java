package com.example.c15347186.e_commerce_app.payment;

public class DebitCard extends Card {
    public DebitCard(String nameOnCard, String number, String cvv, String expirationDate) {
        super(nameOnCard, number, cvv, expirationDate);
    }
    @Override
    protected String getType() {
        return "debit";
    }
    @Override
    protected void executeTransaction(int cents) {
        // Contact bank to execute transaction
    }
}
