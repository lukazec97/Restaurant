package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Confirmed_register extends AppCompatActivity {

    TextView label1,label2;
    Button backtoSignIn;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_confirm);

        initComponents();


    }

    public void initComponents(){

        final int activeUserId = getIntent().getIntExtra("activeid", -1);
        User activeUser = db.getUserById(activeUserId);


        backtoSignIn = (Button)findViewById(R.id.backtoSignIn);
        label1 = (TextView) findViewById(R.id.Text1);
        label2  = (TextView)findViewById(R.id.Text2);

        label1.setText(String.format("Registrovan je novi korisnik sa imenom " + activeUser.getName() +" i prezimenom "+activeUser.getSurname()+ "." + "\n" +
                "Vaše korisničko ime je "+ activeUser.getUsername()+ " ,"+ "lozinka koju ste uneli pri registraciji je: \n" + activeUser.getPassword()));
        label2.setText(String.format("Sve vaše korisniče informacije poslate su na: " + activeUser.getEmail()  + "\n " + "Vaš Computer Shop !"));


        backtoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Confirmed_register.this,SignIn.class);
                startActivity(myIntent);
            }
        });





    }
}

