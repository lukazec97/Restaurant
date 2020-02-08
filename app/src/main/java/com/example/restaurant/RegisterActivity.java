package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {


    EditText inputName,inputSurname, inputUsername, inputPassword, inputBirth,inputEmail;
    Button buttonConfirm, clearform;
    ArrayList<String> users = new ArrayList<String>();
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = (EditText) findViewById(R.id.inputName);
        inputSurname = (EditText) findViewById(R.id.inputSurname);
        inputUsername = (EditText) findViewById(R.id.inputUsernameR);
        inputPassword = (EditText) findViewById(R.id.inputPasswordR);
        inputBirth = (EditText) findViewById(R.id.inputBirth);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
        clearform = (Button)findViewById(R.id.clearForm);




        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String surname = inputSurname.getText().toString();
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                String birth = inputBirth.getText().toString();
                String email = inputEmail.getText().toString();

                db.addUser(name, surname, username, password, birth, email);

                User activeUser = db.getUserByUsername(username);


                Intent intent = new Intent(RegisterActivity.this, Confirmed_register.class);
                intent.putExtra("activeid", activeUser.getUserID());
                startActivity(intent);
            }

        });
        clearform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName.setText("");
                inputSurname.setText("");
                inputUsername.setText("");
                inputPassword.setText("");
                inputBirth.setText("");
                inputEmail.setText("");

            }
        });


    }
}