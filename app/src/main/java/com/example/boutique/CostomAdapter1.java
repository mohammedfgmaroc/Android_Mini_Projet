package com.example.boutique;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CostomAdapter1 extends RecyclerView.Adapter<CostomAdapter1.MyViewHolder> {
    Context context;
    String shoosenametodelete;
    ArrayList shooseid,shoosename,shooseprice,shooseimage;
    CostomAdapter1(Context context,ArrayList shooseid,ArrayList shoosename,ArrayList shooseprice,ArrayList shooseimage){
        this.context = context;
        this.shooseid = shooseid;
        this.shoosename =shoosename;
        this.shooseprice = shooseprice;
        this.shooseimage = shooseimage;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_shop_items,null,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        holder.shooseName.setText(String.valueOf(shoosename.get(holder.getAdapterPosition())));
        holder.shoosePrice.setText(String.valueOf(shooseprice.get(holder.getAdapterPosition())));
        holder.shooseImage.setImageResource(Integer.valueOf((String) shooseimage.get(holder.getAdapterPosition())));
        holder.shooseorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deleteorderintent = new Intent(context,deleteconfirmationActivity.class);
                //intent Extras !!
                deleteorderintent.putExtra("shooseimage",String.valueOf((String) shooseimage.get(holder.getAdapterPosition())));
                deleteorderintent.putExtra("shoosename",String.valueOf(shoosename.get(holder.getAdapterPosition())));
                deleteorderintent.putExtra("shooseprice",String.valueOf(shooseprice.get(holder.getAdapterPosition())));
                //SOlving the out of context issuses !!
                deleteorderintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(deleteorderintent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shooseid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView shooseName , shoosePrice;
        ImageView shooseImage;
        LinearLayout shooseorder;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shooseName = itemView.findViewById(R.id.shoose_name);
            shoosePrice = itemView.findViewById(R.id.shoose_price);
            shooseImage = itemView.findViewById(R.id.imageicon);
            shooseorder = itemView.findViewById(R.id.shooseorder);
        }
    }


}
