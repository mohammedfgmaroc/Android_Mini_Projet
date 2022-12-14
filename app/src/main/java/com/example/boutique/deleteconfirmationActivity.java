package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class deleteconfirmationActivity extends AppCompatActivity {
    ImageView shooseImage;
    TextView shooseName,shoosePrice;
    Button deleteorderbtn;
    String shooseimage,shoosename,shooseprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteconfirmation);
        shooseImage = findViewById(R.id.shooseimagetodelete);
        shooseName = findViewById(R.id.shoosenametodelete);
        shoosePrice = findViewById(R.id.shoosepricetodelete);
        deleteorderbtn = findViewById(R.id.deleteorder);
        shooseimage = getIntent().getStringExtra("shooseimage");
        shoosename = getIntent().getStringExtra("shoosename");
        shooseprice = getIntent().getStringExtra("shooseprice");
        shooseImage.setImageResource(Integer.parseInt(shooseimage));
        shooseName.setText(shoosename);
        shoosePrice.setText(shooseprice);
        deleteorderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            MyDataBase mydb = new MyDataBase(deleteconfirmationActivity.this);
            mydb.deleteOneRow(shoosename);
                Intent intent = new Intent(getApplicationContext(),listview_activity.class);
                startActivity(intent);
            }
        });

    }
}