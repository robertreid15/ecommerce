package com.example.c15347186.e_commerce_app.items;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c15347186.e_commerce_app.R;
import com.example.c15347186.e_commerce_app.Review;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Item> usersList;
    private List<String> following;

    private Context context;

    public ItemAdapter(List<Item> usersList, List<String> following, Context context) {
        this.usersList = usersList;
        this.context = context;
        this.following = following;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        return new ItemViewHolder(layoutView);
    }

    /*
    *       Changed both of Source Compatibility and Target Compatibility to 1.8 so the expressions below would work
    * */

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.mTitle.setText(usersList.get(position).getTitle());
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        if (following.contains(usersList.get(position).getTitle())) {
            holder.mBuy.setText("remove");
        } else {
            holder.mBuy.setText("purchase");
        }

        holder.mBuy.setOnClickListener(view -> {
            if (holder.mBuy.getText().toString().equals("purchase") || !following.contains(usersList.get(holder.getLayoutPosition()).getTitle())) {
                holder.mBuy.setText("remove");
                FirebaseDatabase.getInstance().getReference().child("Users").child("Customer").child(userId).child("cart").child(usersList.get(holder.getLayoutPosition()).getTitle()).setValue(true);
            } else {
                holder.mBuy.setText("purchase");
                FirebaseDatabase.getInstance().getReference().child("Users").child("Customer").child(userId).child("cart").child(usersList.get(holder.getLayoutPosition()).getTitle()).removeValue();
            }
        });

        holder.itemView.setOnClickListener(view -> {
            checkChatId(position);
            //FirebaseDatabase.getInstance().getReference().child("Users").child("Customer").child(userId).child("cart").child(usersList.get(holder.getLayoutPosition()).getTitle()).removeValue();
        });
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }



    private void checkChatId(int position) {

        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String itemTitle = usersList.get(position).getTitle(); // need to add in getKey

        //PUSH ID IF NOT EXIST
        DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference().child("items");
        chatRef.child(currentUserId).child(itemTitle).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*if (!dataSnapshot.exists()) {
                    setChatIdToFirebase(chatRef, currentUserId, itemTitle);
                } else {*/
                    //GET CHAT ID IF EXIST
                    getChatIdFromFirebase(chatRef, currentUserId, itemTitle);
                //}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void navigateToChatActivity(String userId, String chatId) {
        Intent intent = new Intent(context, Review.class);
        Bundle b = new Bundle();
        b.putString("chat_id", chatId);
        b.putString("user_id", userId);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    private void setChatIdToFirebase(DatabaseReference chatRef, String currentUserId, String personId){
        String chat_id = FirebaseDatabase.getInstance().getReference().push().getKey();
        chatRef.child(currentUserId).child(personId).child(chat_id).setValue(true);
        chatRef.child(personId).child(currentUserId).child(chat_id).setValue(true).addOnSuccessListener(aVoid -> navigateToChatActivity(personId, chat_id));
    }


    private void getChatIdFromFirebase(DatabaseReference chatRef, String currentUserId, String personId){
        chatRef.child(currentUserId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String chatId = "";
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        chatId = ds.getKey();

                    }
                    navigateToChatActivity(personId, chatId);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

