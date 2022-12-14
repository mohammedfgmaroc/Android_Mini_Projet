package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText nameInput = findViewById(R.id.register_username_input);
        EditText numInput = findViewById(R.id.register_numero_input);
        EditText pswInput = findViewById(R.id.register_password_input);
        Button registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getApplicationContext() , login_activity.class);
                String name = nameInput.getText().toString();
                String numeroTel = numInput.getText().toString();
                String psw = pswInput.getText().toString();
                registerIntent.putExtra("name",name);
                registerIntent.putExtra("numeroTel",numeroTel);
                registerIntent.putExtra("psw",psw);
                startActivity(registerIntent);
            }
        });
    }
}