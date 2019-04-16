package com.example.c15347186.e_commerce_app.items;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c15347186.e_commerce_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddItems extends AppCompatActivity {
    EditText title, manufacturer, price, category;
    Button mAdd;

    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAdd = (Button) findViewById(R.id.add);


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
                mDatabase.child("Items").push().setValue(item);
            }
        });

        }
    }

