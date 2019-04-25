package com.example.c15347186.e_commerce_app.reviews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.c15347186.e_commerce_app.R;

public class ReviewHolder extends RecyclerView.ViewHolder {
    public TextView itemTitle;
    //public Button mFollow;

    public ReviewHolder(View itemView){
        super(itemView);

        itemTitle = itemView.findViewById(R.id.itemTitle);
        //mFollow = itemView.findViewById(R.id.follow);

    }



}

