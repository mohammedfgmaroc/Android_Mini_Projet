package com.example.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class listview_activity extends AppCompatActivity {
    //Initial vlues for shooses !!
    Shoose shoose[] = {
            new Shoose("Aire Jordan 1 Mid","  500 DH", R.drawable.airejordan1mid,"Inspired by the original AJ1, the Air Jordan 1 Mid offers fans a chance to follow in MJ's footsteps. Fresh color trims the clean, classic materials, imbuing modernity into a classic design."),
            new Shoose("Aire Jordan 37","  560 DH",R.drawable.airejordan37,"You've got the hops and the speed—lace up in shoes that enhance what you bring to the court. The latest AJ is all about takeoffs and landings, with multiple Air units to get you off the ground and our signature Formula 23 foam to cushion your impact. Up top, you'll find layers of tough, reinforced leno-weave fabric that'll keep you contained—and leave your game uncompromised."),
            new Shoose("Jordan ADG 4","  430 DH",R.drawable.jordanadg4,"A request from MJ himself, the Jordan ADG 4 infuses an incredibly classic silhouette with retro Jordan flavor. Supple, full-grain leather shows off the iconic elephant print on the heel. The rubber sole has an integrated traction pattern that perfectly pairs the grip you need with the versatility and comfort you want."),
            new Shoose("Nike Alpha","  600 DH",R.drawable.nikealpha,"Let the baseball world know what kind of bat-wielding beast you are. The midsole has Renew foam cushioning, perfect for sprinting around the bags or robbing your opponent of extra bases in the field. The plush, breathable upper keeps you contained without adding any unnecessary weight. Plus, the grippy rubber peg traction is tailor made for all-out effort plays."),
            new Shoose("Nike Court Zoom","  400 DH",R.drawable.nikecourtzoom,"Innovated to withstand your toughest matches, this updated design puts flexible, durable materials exactly where they're needed most. Signature Rafael Nadal details let you rep your favorite player while you run the court."),
            new Shoose("Nike Free Run","  300 DH",R.drawable.nikefreerun,"The Nike Free Run Shoe has been updated to deliver an even more adaptive fit than before. Stretch material in the upper moves with your foot, while the tri-star outsole pattern adjusts to your every step for a ride that delivers support and flexibility."),
            new Shoose("Nike SB","  360 DH",R.drawable.nikesb,"Light. Effortless. On point. The Nyjah 3 delivers the next iteration of the skate shoe that's as extraordinary as Nyjah. Zoom Air technology in the heel pairs with a honeycomb outsole that's grippy yet featherlight."),
            new Shoose("Nike SFB","  410 DH",R.drawable.nikesfb,"The Nike SFB  Leather Men's Boot brings the Special Field Boot to Nike Sportswear for the first time as a SneakerBoot, complete with weather-resistant leather and a rugged traction pattern."),
            new Shoose("Nike Streakfly","  650 DH", R.drawable.nikestreakfly,"Our lightest racing shoe, the Nike Streakfly is all about the speed you need to take on the competition in a mile, 5k or 10k race. Low profile with sleek details, it feels like it disappears on your foot to help you better connect with the road on the way to your personal best."),
            new Shoose("Nike Zoom","  550 DH",R.drawable.nikezoom,"Designed for action on hard courts, the Nike Zoom HyperAce is a Volleyball Shoe that helps keep you light and fast on your feet with a breathable upper and responsive cushioning.")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);



        ListView listview = findViewById(R.id.shooseList);
        CostumBaseAdapter costumBaseAdapter = new CostumBaseAdapter(getApplicationContext(),shoose);
        listview.setAdapter(costumBaseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent shooseDetailIntent = new Intent(getApplicationContext(),shoose_detail_activity.class);
                shooseDetailIntent.putExtra("shoosenamedetail",shoose[position].shooseName);
                shooseDetailIntent.putExtra("shoosepricedetail",shoose[position].shoosePrice);
                shooseDetailIntent.putExtra("shooseimagedetail",shoose[position].shooseImage);
                shooseDetailIntent.putExtra("shoosedescriptiondetail",shoose[position].shooseDescription);
                startActivity(shooseDetailIntent);
            }
        });
        FloatingActionButton gotobag = findViewById(R.id.gotobagicon);
        gotobag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bagIntent = new Intent(getApplicationContext(),bag_activity.class);
                startActivity(bagIntent);
            }
        });
    }
}