package com.example.c15347186.e_commerce_app.cardValidation;

public class VisaValidation extends AbstractCardValidator {

    public VisaValidation(String cardName, String cardNumber, int expiryDateMonth,
                          int expiryDateYear, String cvv) {

        super(cardName, cardNumber, expiryDateMonth, expiryDateYear, cvv);

    }

    protected boolean validateCardNumberFormat() {

        /* Check number is in correct format for Visa */

        boolean errorInFormat = false;

        if (cardNumber.charAt(0) != '4') {

            errorInFormat = true;

        }
        else {


        }

        return !errorInFormat;

    }

}
