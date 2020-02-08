package com.example.restaurant;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import android.view.View;


import androidx.appcompat.app.AppCompatActivity;


public class UserPage extends AppCompatActivity {

    Button CheckProducts,LogOut;
    Database db = new Database(this);
    int activeUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        activeUserId = getIntent().getIntExtra("activeid", -1);
        User activeUser = db.getUserById(activeUserId);

        initComponents();
    }

    private void initComponents(){

        CheckProducts = (Button)findViewById(R.id.view_dishes);
        LogOut =(Button)findViewById(R.id.logOut);
//        AccInfo = (Button)findViewById(R.id.AccInfo);

        CheckProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dishes = new Intent(UserPage.this, Dishes.class);
                startActivity(Dishes);
            }
        });


        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogOut = new Intent(UserPage.this, Home.class);
                startActivity(LogOut);
                finish();
            }
        });

//        AccInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(UserPage.this, Account_Info.class);
//                myIntent.putExtra("activeid",activeUserId );
//                startActivity(myIntent);
//            }
//        });



    }
}
