package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button joinBtn = findViewById(R.id.join_btn);
        Button haveAccountBtn = findViewById(R.id.have_account_btn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent joinIntent = new Intent(MainActivity.this , register_activity.class);
                startActivity(joinIntent);
            }
        });
        haveAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haveAccountIntent = new Intent(getApplicationContext() , login_activity.class);
                startActivity(haveAccountIntent);
            }
        });
    }
}