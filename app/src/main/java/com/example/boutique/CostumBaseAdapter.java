package com.example.boutique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CostumBaseAdapter extends BaseAdapter
{
    Context context;
    Shoose[] shoose;
    LayoutInflater inflater;
    public CostumBaseAdapter(Context ctx,Shoose[] shoose){
        this.context = ctx;
        this.shoose = shoose;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return shoose.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
    convertview = inflater.inflate(R.layout.activity_shop_items,null);
        TextView textViewTitle = convertview.findViewById(R.id.shoose_name);
        TextView textViewPrice = convertview.findViewById(R.id.shoose_price);
        ImageView imageView = convertview.findViewById(R.id.imageicon);
        textViewTitle.setText(shoose[position].shooseName);
        textViewPrice.setText(shoose[position].shoosePrice);
        imageView.setImageResource(shoose[position].shooseImage);
        return convertview;
    }
}
