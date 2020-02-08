package com.example.restaurant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class singleDish extends AppCompatActivity {

    TextView naziv, cena;
    ImageView dishPicuture;
    Button addcart,buttonBack;

    int did;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_dish);

        naziv = (TextView) findViewById(R.id.naziv);
        dishPicuture = (ImageView) findViewById(R.id.dishPicture);
        cena = (TextView) findViewById(R.id.cena);
        addcart =(Button)findViewById(R.id.addcart);
        buttonBack =(Button) findViewById(R.id.buttonBack);


        int id = getIntent().getIntExtra("dishId",0);

        initComponents(id);
    }


    @SuppressLint("HandlerLeak")
    private void initComponents(int id){
        Api.getJSON("http://192.168.0.31:5000/dishes/"+ String.valueOf(id), new ReadDataHandler(){
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    final Dish d = com.example.restaurant.Dish.parseJSON(object);

                    naziv =(TextView) findViewById(R.id.naziv);

                    dishPicuture  = (ImageView) findViewById(R.id.dishPicture);

                    cena = (TextView)findViewById(R.id.cena);

                    naziv.setText(d.getNaziv());
                    cena.setText("The price is : " + String.valueOf(d.getCena() + "$"));

                    did = d.getId();

                    switch (d.getTip()) {
                        case "Pizza":
                            dishPicuture.setImageResource(R.drawable.pizza);
                            break;
                        case "Sea_food":
                            dishPicuture.setImageResource(R.drawable.sf);
                            break;
                        case "paste":
                            dishPicuture.setImageResource(R.drawable.pasta);
                            break;
                    }


                } catch (Exception e) {
                    ((TextView)findViewById(R.id.naziv)).setText(response);
                }


            }
            //http://192.168.0.13:5000/dishes/

        });
        Api.getJSON("http://192.168.0.31:5000/dishes/"+ String.valueOf(id), new ReadDataHandler(){
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    final Dish d = com.example.restaurant.Dish.parseJSON(object);

                    naziv =(TextView) findViewById(R.id.naziv);
                    dishPicuture  = (ImageView) findViewById(R.id.dishPicture);
                    cena = (TextView)findViewById(R.id.cena);

                    naziv.setText(d.getNaziv());
                    cena.setText("The price is : " + String.valueOf(d.getCena() + "$"));

                    did = d.getId();

                    switch (d.getTip()) {
                        case "Pizza":
                            dishPicuture.setImageResource(R.drawable.pizza);
                            break;
                        case "Sea_food ":
                            dishPicuture.setImageResource(R.drawable.sf);
                            break;
                        case "paste":
                            dishPicuture.setImageResource(R.drawable.pasta);
                            break;
                    }


                } catch (Exception e) {
                    ((TextView)findViewById(R.id.naziv)).setText(response);
                }
                //((TextView)findViewById(R.id.labelJson)).setText(odgovor);

            }

        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(singleDish.this,
                        Dishes.class);
                startActivity(myIntent);
            }
        });

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(singleDish.this,Buy.class);
                Bundle b = new Bundle();
                b.putInt("id", did);
                myIntent.putExtras(b);

                startActivity(myIntent);
            }
        });



    }




}
