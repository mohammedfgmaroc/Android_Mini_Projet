package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText loginput = findViewById(R.id.username_input);
        EditText pswinput = findViewById(R.id.password_input);
        Button loginbtn = findViewById(R.id.login_btn);

         class Client{
            String name;
            String numTel;
            String psw;
            public Client(String name,String numTel,String psw){
                this.name = name;
                this.numTel = numTel;
                this.psw = psw;
            }

            public String getName() {
                return name;
            }

            public String getNumTel() {
                return numTel;
            }

            public String getPsw() {
                return psw;
            }
        }

    loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent registrationIntent = getIntent();
            Client usr = new Client(registrationIntent.getStringExtra("name"), registrationIntent.getStringExtra("numeroTel"), registrationIntent.getStringExtra("psw"));


                if (loginput.getText().toString().equals(usr.name) && pswinput.getText().toString().equals(usr.psw)) {
                    Intent logedIntent = new Intent(getApplicationContext(), listview_activity.class);
                    Toast.makeText(getApplicationContext(),"Welcom "+usr.name,Toast.LENGTH_LONG).show();
                    startActivity(logedIntent);
                }
                else {
                    Toast.makeText(login_activity.this,"ERROR ! USER NOT FOUND !!",Toast.LENGTH_LONG).show();
                    Intent backToRegistrationIntent = new Intent(getApplicationContext() , register_activity.class);
                    startActivity(backToRegistrationIntent);
                }

        }
    });
    }
}