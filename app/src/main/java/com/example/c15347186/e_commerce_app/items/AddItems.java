package com.example.c15347186.e_commerce_app.items;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.c15347186.e_commerce_app.R;
import com.example.c15347186.e_commerce_app.UserMainPage;
import com.example.c15347186.e_commerce_app.findUsers.FindUserActivity;
import com.example.c15347186.e_commerce_app.reviews.FindReviewActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItems extends AppCompatActivity {
    EditText title, manufacturer, price, category;
    Button mAdd, mFindUsers, mFindItems, completeOrder, mFindReviews;

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAdd = (Button) findViewById(R.id.add);
        mFindUsers = (Button) findViewById(R.id.findUsers);
        mFindItems = (Button) findViewById(R.id.findItems);
        //completeOrder = (Button) findViewById(R.id.completeOrderAdmin);
        mFindReviews = (Button) findViewById(R.id.viewReviews);


        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTitle = (EditText) findViewById(R.id.title);
                String title = editTitle.getText().toString();

                EditText editmanufacturer = (EditText) findViewById(R.id.manufacturer);
                String manufacturer = editmanufacturer.getText().toString();

                EditText editprice = (EditText) findViewById(R.id.price);
                String price = editprice.getText().toString();

                EditText editcategory = (EditText) findViewById(R.id.category);
                String category = editcategory.getText().toString();


                Item item = new Item(title, manufacturer, price, category);
                //Item item = new ItemBuilder().setTitle(title).setManufacturer(manufacturer).setPrice(price).setCategory(category).createItem();
                mDatabase.child("Items").push().setValue(item);
            }
        });

        mFindUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddItems.this, FindUserActivity.class);
                startActivity(i);
            }
        });

        mFindReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddItems.this, FindReviewActivity.class);
                startActivity(i);
            }
        });

        mFindItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddItems.this, FindItemActivity.class);
                startActivity(i);
            }
        });
    }
}

