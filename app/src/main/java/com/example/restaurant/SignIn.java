package com.example.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    EditText inputusername, inputpassword,name,email;
    Button signIn,register;
    Database db = new Database(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputusername = (EditText) findViewById(R.id.username);
        inputpassword = (EditText) findViewById(R.id.password);
        name = (EditText)findViewById(R.id.inputName);
        email = (EditText)findViewById(R.id.inputEmail);
        signIn = (Button) findViewById(R.id.signIn);
        register = (Button)findViewById(R.id.register);


        initComponents();
    }

    private void initComponents( ){

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = inputusername.getText().toString();
                String password = inputpassword.getText().toString();
                User user = db.getUserByUsername(username);

                if(user!=null)
                {
                    if(password.equals(user.getPassword()))
                    {
                        Intent intent = new Intent(SignIn.this, UserPage.class);
                        intent.putExtra("activeid", user.getUserID());
                        startActivity(intent);
                    }else
                        Toast.makeText(SignIn.this, "Invalid Password", Toast.LENGTH_LONG).show();



                }else
                    Toast.makeText(SignIn.this, "Invalid Username", Toast.LENGTH_LONG).show();



            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignIn.this,RegisterActivity.class);
                Bundle b = new Bundle();
                myIntent.putExtras(b);

                startActivity(myIntent);
            }
        });



    }

}


