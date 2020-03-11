package com.example.artapp;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userID == post.userID &&
                timeStamp == post.timeStamp &&
                tags.equals(post.tags) &&
                message.equals(post.message) &&
                image.equals(post.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, tags, timeStamp, message, image);
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
