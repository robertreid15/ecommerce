package com.example.c15347186.e_commerce_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bmanager, blabourer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmanager = (Button) findViewById(R.id.manager);
        //blabourer = (Button) findViewById(R.id.labourer);

    }

    public void bmanager_onClick(View v){
        Toast.makeText(MainActivity.this, "call manager login", Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(i);
    }


    /*public void blabourer_onClick(View v){
        Intent i = new Intent(MainActivity.this, LabourerLoginActivity.class);
        startActivity(i);
    }

    public void bGoogleSearch_onClick(View v){
        Intent i = new Intent(MainActivity.this, GoogleSearch.class);
        startActivity(i);
    }

    public void bRecyclerView_onClick(View v){
        Intent i = new Intent(MainActivity.this, DisplayUserActivity.class);
        startActivity(i);
    }

    public void bShake_onClick(View v){
        Intent i = new Intent(MainActivity.this, Accelerometer.class);
        startActivity(i);
    }*/
}

