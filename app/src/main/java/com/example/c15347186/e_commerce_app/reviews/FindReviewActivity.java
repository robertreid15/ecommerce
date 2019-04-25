package com.example.c15347186.e_commerce_app.reviews;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.c15347186.e_commerce_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FindReviewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> followingIds = new ArrayList<>();
    private ArrayList<Review> results = new ArrayList<>();
    EditText mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_review);

        mInput = findViewById(R.id.input);
        Button mSearch = findViewById(R.id.search);

        //getAllUsers();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplication());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ReviewAdapter(results, followingIds, FindReviewActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        mSearch.setOnClickListener(view -> {
            //clear();
            //getAllUsers();
        });

    }

    private void getFollowing() {
        DatabaseReference userFollowingDB = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("contacts");
        userFollowingDB.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                followingIds.clear();
                if (dataSnapshot.exists()){
                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                        String uid = ds.getKey();
                        Log.d("uid", uid);
                        if (uid != null && !followingIds.contains(uid)){
                            followingIds.add(uid);
                        }
                    }

                }

                mAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    /*Search for email in the users child and start with whatever is in the mInput.getText*/

    /*private void getAllUsers() {

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Customer");
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                results.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        String email = ds.child("email").getValue().toString();
                        String uid = ds.getKey();

                        if(!email.equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())){
                            Review obj = new Review(email, uid);
                            results.add(obj);

                        }
                    }
                    getFollowing();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    private void clear() {
        int size = this.results.size();
        this.results.clear();
        mAdapter.notifyItemRangeChanged(0, size);
    }*/

}
