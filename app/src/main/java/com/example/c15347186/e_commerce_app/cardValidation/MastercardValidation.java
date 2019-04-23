package com.example.c15347186.e_commerce_app.cardValidation;

public class MastercardValidation extends AbstractCardValidator {

    public MastercardValidation(String cardName, String cardNumber, int expiryDateMonth,
                                int expiryDateYear, String cvv) {

        super(cardName, cardNumber, expiryDateMonth, expiryDateYear, cvv);
    }


    /* Overridden method */

    protected boolean validateCardNumberFormat() {

        /* Check number is in correct format for MasterCard */

        boolean errorInFormat = false;

        if (cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5')) {

        }
        else {

            errorInFormat = true;

        }

        return !errorInFormat;

    }

}
