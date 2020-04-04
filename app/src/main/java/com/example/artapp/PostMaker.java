package com.example.artapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    public static final String EXTRA_THING = "com.example.artapp.POST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_maker);
    }

    /*************************************************************************************************
     * SEND POST
     * creates a new post, adds the user input to said post, and then used the database refrence
     * to send it to the firebase realtime database !!!NOT CLOUD FIRESTORE THAT THING IS A NIGHTMARE!!!
     * lastly we return to the main session
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
        String challengeID = database.push().getKey();
        System.out.println("Challenge ID: " + challengeID);

        database.child(challengeID).setValue(newPost);

        Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);

        /*EditText message = (EditText) findViewById(R.id.postDescription);
        EditText tags = (EditText) findViewById(R.id.postTags);
        EditText cost = (EditText) findViewById(R.id.postAskingPrice);
        //duplicate that line ^^ for the three attributes, use strings, and make one large string with all of it, called message
        String description = message.getText().toString();
        String points = tags.getText().toString();
        String money = cost.getText().toString();
        String sender = description + ", " + points + ", " + money;*/

        intent.putExtra(EXTRA_THING, challengeID);
        startActivity(intent);
    }
}


