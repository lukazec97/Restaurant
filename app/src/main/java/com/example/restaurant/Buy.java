package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class Buy extends AppCompatActivity {

    Button submit, reset;
    EditText name, surname, email, adress, phone_num;
    Spinner payment;
    CheckBox verify;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_cart);



        initComponents();

    }

    public void initComponents(){

        submit = (Button)findViewById(R.id.submit);
        reset = (Button)findViewById(R.id.reset);
        name =(EditText)findViewById(R.id.name);
        surname =(EditText)findViewById(R.id.surname);
        email = (EditText)findViewById(R.id.email);
        adress = (EditText)findViewById(R.id.adress);
        phone_num = (EditText)findViewById(R.id.phone_num);
        verify =(CheckBox)findViewById(R.id.verify);
        payment =(Spinner)findViewById(R.id.payment);

        final Spinner payment = (Spinner)findViewById(R.id.payment);
        payment.setAdapter(new ArrayAdapter<Order.Payment>(this, android.R.layout.simple_spinner_item, Order.Payment.values()));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cid = getIntent().getIntExtra("id", 0);
                Intent myIntent = new Intent(Buy.this,Confirmed_Order.class);

                myIntent.putExtra("id", cid);
                myIntent.putExtra("name", name.getText().toString());
                myIntent.putExtra("surname", surname.getText().toString());
                myIntent.putExtra("еmail", email.getText().toString());
                myIntent.putExtra("adress", adress.getText().toString());
                myIntent.putExtra("phone", phone_num.getText().toString());
                myIntent.putExtra("payment", payment.getSelectedItem().toString());

                startActivity(myIntent);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name.setText("");
               surname.setText("");
               email.setText("");
               adress.setText("");
               phone_num.setText("");
               verify.setChecked(false);

            }
        });











    }
}
