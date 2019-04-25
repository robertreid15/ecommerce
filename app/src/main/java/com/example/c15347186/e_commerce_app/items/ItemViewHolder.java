package com.example.c15347186.e_commerce_app.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.c15347186.e_commerce_app.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView mTitle;
    public Button mBuy;

    public ItemViewHolder(View itemView){
        super(itemView);

        mTitle = itemView.findViewById(R.id.title);
        mBuy = itemView.findViewById(R.id.buy);

    }

}
