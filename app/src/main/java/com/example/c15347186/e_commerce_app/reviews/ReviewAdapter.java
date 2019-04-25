package com.example.c15347186.e_commerce_app.reviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c15347186.e_commerce_app.R;
import com.example.c15347186.e_commerce_app.reviews.ReviewHolder;
import com.example.c15347186.e_commerce_app.reviews.Review;
import com.example.c15347186.e_commerce_app.findUsers.FollowViewHolders;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewHolder> {

        private List<Review> usersList;
        private List<String> following;

        private Context context;

        public ReviewAdapter(List<Review> usersList, List<String> following, Context context) {
            this.usersList = usersList;
            this.context = context;
            this.following = following;

        }

        @Override
        public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_reviews, null);
            return new ReviewHolder(layoutView);
        }

        @Override
        public void onBindViewHolder(final ReviewHolder holder, int position) {
            holder.itemTitle.setText(usersList.get(position).getItemTitle());

        }

        @Override
        public int getItemCount() {
            return this.usersList.size();
        }

    }


