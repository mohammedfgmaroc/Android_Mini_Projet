package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class shoose_detail_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoose_detail);
        Intent shoosedetailintent = getIntent();
        Shoose shoosedetail;
        ImageView shooseimagedetail = findViewById(R.id.shooseimage_detail);
        TextView shoosename = findViewById(R.id.shoosename_detail);
        TextView shoosedescription = findViewById(R.id.shoosedescription_detail);
        TextView shooseprice = findViewById(R.id.shooseprice_detail);
        Button addtobagdbutton = findViewById(R.id.addtobag_button);
        shoosedetail = new Shoose(shoosedetailintent.getStringExtra("shoosenamedetail"),shoosedetailintent.getStringExtra("shoosepricedetail"),shoosedetailintent.getIntExtra("shooseimagedetail",1),shoosedetailintent.getStringExtra("shoosedescriptiondetail"));
        shooseimagedetail.setImageResource(shoosedetail.getShooseImage());
        shoosename.setText(shoosedetail.getShooseName());
        shooseprice.setText(shoosedetail.getShoosePrice());
        shoosedescription.setText(shoosedetail.getShooseDescription());
        //add to bag operation !!
        addtobagdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent addtobagintent = new Intent(getApplicationContext(),bag_activity.class);
            MyDataBase mydb = new MyDataBase(shoose_detail_activity.this);
            mydb.addtobag(shoosedetail.shooseName,shoosedetail.shoosePrice,shoosedetail.shooseImage);
            startActivity(addtobagintent);
            }
        });


    }
}