package com.example.c15347186.e_commerce_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c15347186.e_commerce_app.cardValidation.AbstractCardValidator;
import com.example.c15347186.e_commerce_app.cardValidation.AmericanExpressValidation;
import com.example.c15347186.e_commerce_app.cardValidation.MastercardValidation;
import com.example.c15347186.e_commerce_app.cardValidation.VisaValidation;


public class completeOrder extends AppCompatActivity {

    EditText cardType, cardName, cardNumber, expiryDateMonth,
            expiryDateYear, cvv;
    Button completeOrder;

    //private DatabaseReference mDatabase;

    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        //mDatabase = FirebaseDatabase.getInstance().getReference();
        completeOrder = (Button) findViewById(R.id.completeOrder);
        //mFindUsers = (Button) findViewById(R.id.findUsers);


        completeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editCardName = (EditText) findViewById(R.id.cardName);
                String cardName = editCardName.getText().toString();

                EditText editcardNumber = (EditText) findViewById(R.id.cardNumber);
                String cardNumber = editcardNumber.getText().toString();

                EditText editexpiryDateMonth = (EditText) findViewById(R.id.expiryDateMonth);
                String expiryDateMonth1 = editexpiryDateMonth.getText().toString();
                int expiryDateMonthInt =Integer.parseInt(expiryDateMonth1);

                EditText editexpiryDateYear = (EditText) findViewById(R.id.expiryDateYear);
                String expiryDateYear1 = editexpiryDateYear.getText().toString();
                int expiryDateYearInt =Integer.parseInt(expiryDateYear1);

                EditText editcvv = (EditText) findViewById(R.id.cvv);
                String cvv = editcvv.getText().toString();

                EditText editcardType = (EditText) findViewById(R.id.cardType);
                String cardType = editcardType.getText().toString();

                boolean result = false;
                AbstractCardValidator validator = null;

                if (cardType.equals("Visa Card")) {
                    validator = new VisaValidation(cardName, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                } else if (cardType.equals("MasterCard")) {
                    validator = new MastercardValidation(cardName, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                } else if (cardType.equals("American Express")) {
                    validator = new AmericanExpressValidation(cardName, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                }

                result = validator.validate();
                if (!result) {
                    Toast.makeText(getApplicationContext(), "Invalid Card Details", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                    /*
                    *       There'll be functionality here eventually. just have a toast meessage so far in order to test
                    * */
                }
            }
        });

    }
}

