package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class bag_activity extends AppCompatActivity {
    MyDataBase mydb;
    ArrayList<String> shooseid,shoosename,shooseprice,shooseimage;
    CostomAdapter1 costomAdapter1;
    RecyclerView recyclerView;
    Button confirmbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);
        mydb = new MyDataBase(getApplicationContext());
        shooseid = new ArrayList<>();
        shoosename = new ArrayList<>();
        shooseprice = new ArrayList<>();
        shooseimage = new ArrayList<>();
        confirmbtn = findViewById(R.id.confirmfinalorder);
        recyclerView = findViewById(R.id.shoosebag);
        storeDataInShooseArray();
        costomAdapter1 = new CostomAdapter1(getApplicationContext(),shooseid,shoosename,shooseprice,shooseimage);
        recyclerView.setAdapter(costomAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(bag_activity.this));
        // total price
        int totalPrice = 0;
        if(costomAdapter1.getItemCount() > 0){
            for (int i=0;i<costomAdapter1.getItemCount();i++){
                String v = shooseprice.get(i);
                totalPrice = totalPrice + Integer.parseInt(v.replaceAll("[^0-9]",""));
            }
        }

        TextView totalprice = findViewById(R.id.totalprice);
        totalprice.setText("Total Price :  " + totalPrice+ " DH");
        //confirmer la commande !!
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),listview_activity.class);
                //envoyer ma commande vers une autre activite avec une autre table dans la base de donnee par exemple !!
                Toast.makeText(getApplicationContext(),"Order Confirmed ...",Toast.LENGTH_LONG).show();
                MyDataBase mydb = new MyDataBase(getApplicationContext());
                mydb.deleteAll();
                startActivity(intent);
            }
        });

    }
    void storeDataInShooseArray(){
        Cursor cursor = mydb.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"NO DATA !",Toast.LENGTH_LONG).show();
        }
        else{
            while (cursor.moveToNext()){
                shooseid.add(cursor.getString(0));
                shoosename.add(cursor.getString(1));
                shooseprice.add(cursor.getString(2));
                shooseimage.add(cursor.getString(3));

            }
        }
    }

}