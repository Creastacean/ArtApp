package com.example.artapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //I don't think we need this here, need to check
    PostMaker postMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        //I like this comment better, so i deleted the first one :)
        //here' another comment
        //you guys are ridiculous
        //Don't make fun of me! YOu're not my mom!!
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