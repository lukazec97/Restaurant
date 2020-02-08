package com.example.restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Dishes extends AppCompatActivity {

    ArrayList<LinearLayout> lista = new ArrayList<>();

    LinearLayout Pizza, morski_plodovi, paste;
    private ArrayList<Dish> dishes;
    private Object singleDish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishes);



        Pizza = (LinearLayout) findViewById(R.id.pizza);
        morski_plodovi = (LinearLayout) findViewById(R.id.morski_plodovi);
        paste = (LinearLayout) findViewById(R.id.paste);

        Intent singleDish = new Intent(this, singleDish.class);

        initComponents(singleDish);
    }

    private void initComponents(final Intent singleDish){



        dishes = API_Dish.getDishes();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Pizza = (LinearLayout) findViewById(R.id.pizza);
        morski_plodovi = (LinearLayout) findViewById(R.id.morski_plodovi);
        paste = (LinearLayout) findViewById(R.id.paste);
        EditText searchBar = (EditText)findViewById(R.id.searchBar);

        for (final Dish d : dishes) {

            LinearLayout item = (LinearLayout) inflater.inflate(R.layout.dish_image, null);

            switch (d.getTip()) {
                case "Pizza":
                    ((ImageView) item.findViewById(R.id.dishPicture)).setImageResource(R.drawable.pizza);
                    break;
                case "Sea_food":
                    ((ImageView) item.findViewById(R.id.dishPicture)).setImageResource(R.drawable.sf);
                    break;
                case "paste":
                    ((ImageView) item.findViewById(R.id.dishPicture)).setImageResource(R.drawable.pasta);
                    break;
            }

            switch(d.getTip()) {
                case "Pizza":
                    Pizza.addView(item);
                    break;
                case "Sea_food":
                    morski_plodovi.addView(item);
                    break;
                case "paste":
                    paste.addView(item);
                    break;
            }



            ((TextView)item.findViewById(R.id.labelName)).setText(d.getNaziv());

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    singleDish.putExtra("dishId", d.getId());
                    startActivity(singleDish);

                }
            });

            lista.add(item);

        }

        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                for(LinearLayout item: lista)
                    item.setBackgroundResource(R.drawable.ltrans);
                if(s.length() != 0)
                {
                    for (LinearLayout item : lista)
                    {
                        String st = ((TextView)item.findViewById(R.id.labelName)).getText().toString().toLowerCase();
                        if(st.contains(s))
                        {
                            item.setBackgroundResource(R.drawable.lback);
                        }
                    }
                }
            }
        });




    }
}
