package com.example.c15347186.e_commerce_app.findUsers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c15347186.e_commerce_app.R;

import java.util.List;

/*
*       This Class
* */

public class FollowAdapter extends RecyclerView.Adapter<FollowViewHolders> {

    private List<FollowObject> usersList;
    private List<String> following;

    private Context context;

    public FollowAdapter(List<FollowObject> usersList, List<String> following, Context context) {
        this.usersList = usersList;
        this.context = context;
        this.following = following;

    }

    @Override
    public FollowViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_users, null);
        return new FollowViewHolders(layoutView);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolders holder, int position) {
        holder.mEmail.setText(usersList.get(position).getEmail());

       /* if (following.contains(usersList.get(position).getUid())) {
            holder.mFollow.setText("following");
        } else {
            holder.mFollow.setText("follow");
        }

        holder.mFollow.setOnClickListener(view -> {
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            if (holder.mFollow.getText().toString().equals("follow") || !following.contains(usersList.get(holder.getLayoutPosition()).getUid())) {
                holder.mFollow.setText("following");
                FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("contacts").child(usersList.get(holder.getLayoutPosition()).getUid()).setValue(true);
            } else {
                holder.mFollow.setText("follow");
                FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("contacts").child(usersList.get(holder.getLayoutPosition()).getUid()).removeValue();
            }
        });

        holder.itemView.setOnClickListener(view -> {
            //checkChatId(position);
        });*/


        /*
        *       here we should have an onClickListener that directs admins to viewing customer carts.
        * */
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

}
