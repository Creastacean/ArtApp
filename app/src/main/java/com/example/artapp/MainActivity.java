package com.example.artapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //I don't think we need this here, need to check
    PostMaker postMaker;
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //I like this comment better, so i deleted the first one :)
        //here' another comment
        //you guys are ridiculous
        //Don't make fun of me! YOu're not my mom!!
        final String message = "no posts";
        Intent intent = getIntent();
        if(intent.getStringExtra(PostMaker.EXTRA_THING) != null) {

            final String ID = intent.getStringExtra(PostMaker.EXTRA_THING);
            database = FirebaseDatabase.getInstance().getReference().child("Post");
            ValueEventListener listener = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String Desc = dataSnapshot.child(ID).child("message").getValue(String.class);
                    String Tags = dataSnapshot.child(ID).child("tags").getValue(String.class);
                    String Cost = dataSnapshot.child(ID).child("priceOrOffer").getValue(String.class);
                    TextView msg = findViewById(R.id.message);
                    TextView tgs = findViewById(R.id.tags);
                    TextView cst = findViewById(R.id.priceOffer);
                    msg.setText(Desc);
                    tgs.setText(Tags);
                    cst.setText("$" + Cost);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

            database.addValueEventListener(listener);

        }
        else{
            TextView msg = findViewById(R.id.message);
            TextView tgs = findViewById(R.id.tags);
            TextView cst = findViewById(R.id.priceOffer);
            msg.setText("None");
            tgs.setText("None");
            cst.setText("$" + "Cost");
        }


        
    }

    /********************************************************************************
     * SWITCH TO POST
     * if called by a button the view will change to the activity post maker activity
     *******************************************************************************/
    public void switchToPost(View view) {
        Intent intent = new Intent(this, PostMaker.class);
        startActivity(intent);
    }
}