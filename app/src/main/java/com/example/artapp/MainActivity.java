package com.example.artapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        database = FirebaseDatabase.getInstance().getReference().child("Post");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        database.addValueEventListener(ValueEventListener listener);



        //Intent intent = getIntent();
        //String message = intent.getStringExtra(PostMaker.EXTRA_THING);
        //I got a string back to the main activity. but i am not sure how to handle the obvious
        //case where we haven't even left the main activity yet, let alone returned.
        //how do we determin that is the case, once that is understood then it should be a simple
        //matter of wrapping some of this in an if statement.
        //then in theory i believe the resulting string would also need to be parsed.
        //some of it at least kind of makes sense.
        TextView textView = findViewById(R.id.textView5); //would need renamed for whatever we call the textbox
        textView.setText(message);

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