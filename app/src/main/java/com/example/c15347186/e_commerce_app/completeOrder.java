package com.example.c15347186.e_commerce_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c15347186.e_commerce_app.cardValidation.AmericanExpressValidation;
import com.example.c15347186.e_commerce_app.cardValidation.MastercardValidation;
import com.example.c15347186.e_commerce_app.cardValidation.VisaValidation;
import com.example.c15347186.e_commerce_app.cardValidation.AbstractCardValidator;
import com.example.c15347186.e_commerce_app.items.Item;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class completeOrder extends AppCompatActivity {

    private List<Item> cart;

    FirebaseDatabase mFirebaseDatabase;
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference myRef;
    static final String TAG = "AddToDatabase";
    private FirebaseAuth mAuth;
    private Context context;
    String userID;
    Boolean title;

    EditText cardType, cardName, number, expiryMonth,
            expiryYear, editCvv;
    Button completeOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        completeOrder = findViewById(R.id.completeOrder);
        cardType = findViewById(R.id.cardType);
        cardName = findViewById(R.id.cardName);
        number = findViewById(R.id.cardNumber);
        expiryMonth = findViewById(R.id.expiryDateMonth);
        expiryYear = findViewById(R.id.expiryDateYear);
        editCvv = findViewById(R.id.cvv);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        completeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = cardName.getText().toString();

                String cardNumber = number.getText().toString();

                String cardExpiryMonth = expiryMonth.getText().toString();
                int expiryDateMonthInt = Integer.parseInt(cardExpiryMonth);

                String cardExpiryYear = expiryYear.getText().toString();
                int expiryDateYearInt =Integer.parseInt(cardExpiryYear);

                String cvv = editCvv.getText().toString();

                String type = cardType.getText().toString();

                boolean result = false;
                AbstractCardValidator validator = null;

                if (type.trim().equalsIgnoreCase("Visa Card")) {
                    validator = new VisaValidation(name, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                } else if (type.trim().equalsIgnoreCase("MasterCard")) {
                    validator = new MastercardValidation(name, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                } else if (type.trim().equalsIgnoreCase("American Express")) {
                    validator = new AmericanExpressValidation(name, cardNumber, expiryDateMonthInt,
                            expiryDateYearInt, cvv);

                }

                result = validator.validate();
                if (!result) {
                    Toast.makeText(getApplicationContext(), "Invalid Card Details", Toast.LENGTH_SHORT).show();

                }
                else {
                    final FirebaseUser user = mAuth.getCurrentUser();
                    userID = user.getUid();
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    final DatabaseReference cartDb = FirebaseDatabase.getInstance().getReference().child("Users").child("Customer").child(userID).child("cart");
                    cartDb.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                //title = ds.child(getTitle()).getValue(String.class);
                                Boolean item = ds.getValue(Boolean.class);
                                myRef.child("Users").child("Customer").child(userID).child("purchase_history").push().setValue(item);
                                Intent i = new Intent(completeOrder.this, UserMainPage.class);
                                startActivity(i);
                                finish();
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                }
            }
        });

    }
}

