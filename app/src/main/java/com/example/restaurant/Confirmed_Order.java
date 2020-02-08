package com.example.restaurant;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Confirmed_Order extends AppCompatActivity {

    TextView label1, label2, label3;
    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirmation_order);

        initComponents();

    }

    public void initComponents() {

        int cid = getIntent().getIntExtra("id", 0);

        final String Text1 = getIntent().getStringExtra("name");
        final String Text2 = getIntent().getStringExtra("surname");
        final String Text3 = getIntent().getStringExtra("еmail");
        final String Text4 = getIntent().getStringExtra("adress");
        final String Text6 = getIntent().getStringExtra("payment");



        label1 = (TextView) findViewById(R.id.Text1);
        label2 = (TextView) findViewById(R.id.Text2);
        label3 = (TextView) findViewById(R.id.Text3);
        home =(Button)findViewById(R.id.back_menu);



        label1.setText("Food was ordered by \n" + Text1 +" "+ Text2);
        label2.setText("Delivery on adress: " + Text4 + " .");
        label3.setText("User paid using " + Text6 +"\nOther details you can find on: " + Text3 + "\nThanks for visiting us.  \nYour restaurant! :) ");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Confirmed_Order.this,UserPage.class);
                startActivity(i);
            }
        });


    }




}