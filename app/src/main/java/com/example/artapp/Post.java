package com.example.artapp;

public class Post {
    int userID;
    String tags;
    int timeStamp;
    String message;
    String image;
    public Post() {
        image = "null";
        message = "blank";
        tags = "null";
        timeStamp = -1;
        userID = -1;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }
}
