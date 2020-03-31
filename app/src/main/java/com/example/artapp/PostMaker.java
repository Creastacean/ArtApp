package com.example.artapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostMaker extends AppCompatActivity {

    //vars for sending a post to the server
    EditText description;
    EditText tags;
    EditText price;
    Button postButton;
    Post newPost;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_maker);
    }

    /*************************************************************************************************
     * SEND POST
     * creates a new post, adds the user input to said post, and then used the database refrence
     * to send it to the firebase realtime database !!!NOT CLOUD FIRESTORE THAT THING IS A NIGHTMARE!!!
     **************************************************************************************************/
    public void sendPost(View view) {
        //I got rid of this and it still works, I'm just afraid to erase it still
        //https://stackoverflow.com/questions/10586783/how-to-findviewbyid-form-another-xml-file
        //View postView = LayoutInflater.from(getApplication()).inflate(R.layout.activity_post_maker, null);

        description = (EditText)findViewById(R.id.postDescription);
        tags = (EditText)findViewById(R.id.postTags);
        price = (EditText)findViewById(R.id.postAskingPrice);
        postButton = (Button)findViewById(R.id.savePost);
        newPost = new Post();

        database = FirebaseDatabase.getInstance().getReference().child("Post");

        newPost.setMessage(description.getText().toString().trim());
        newPost.setTags(tags.getText().toString().trim());
        newPost.setPriceOrOffer(price.getText().toString().trim());

        database.push().setValue(newPost);
    }
}


