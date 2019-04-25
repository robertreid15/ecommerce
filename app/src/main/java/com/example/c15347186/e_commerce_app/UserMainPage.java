package com.example.c15347186.e_commerce_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c15347186.e_commerce_app.items.FindItemActivity;

public class UserMainPage extends AppCompatActivity {
    Button mFindItems, completeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);

        mFindItems = (Button) findViewById(R.id.findItems);
        completeOrder = (Button) findViewById(R.id.completeOrder);

        mFindItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserMainPage.this, FindItemActivity.class);
                startActivity(i);
            }
        });

        completeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserMainPage.this, completeOrder.class);
                startActivity(i);
            }
        });
    }
}
