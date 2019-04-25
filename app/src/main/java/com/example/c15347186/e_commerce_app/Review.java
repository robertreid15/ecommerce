package com.example.c15347186.e_commerce_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Review extends AppCompatActivity {
    EditText title;
    Button mAdd;
    private String personId;
    private String chatId;
    private String currentUserID;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAdd = (Button) findViewById(R.id.addReview);

        currentUserID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        personId = getIntent().getStringExtra("user_id");
        chatId = getIntent().getStringExtra("chat_id");

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTitle = (EditText) findViewById(R.id.review);
                String title = editTitle.getText().toString();

                //mDatabase.child("Items").push().setValue(title);
                FirebaseDatabase.getInstance().getReference().child("Items").child(chatId).child("review").child(personId).push().setValue(title);


            }
        });
    }
}
