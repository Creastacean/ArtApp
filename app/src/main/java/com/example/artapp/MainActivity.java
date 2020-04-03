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


        //I got a string back to the main activity. but i am not sure how to handle the obvious
        //case where we haven't even left the main activity yet, let alone returned.
        //how do we determin that is the case, once that is understood then it should be a simple
        //matter of wrapping some of this in an if statement.
        //then in theory i believe the resulting string would also need to be parsed.
        //some of it at least kind of makes sense.
         //would need renamed for whatever we call the textbox
        //textView.setText(message);

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