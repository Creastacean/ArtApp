package com.example.artapp;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class PostTest {
    @Test
    public void testPostConstructor() {
        try {
            Field pic = Post.class.getDeclaredField("image");
            pic.setAccessible(true);
            Field mess = Post.class.getDeclaredField("message");
            mess.setAccessible(true);
            Field tag = Post.class.getDeclaredField("tags");
            tag.setAccessible(true);
            Field time = Post.class.getDeclaredField("timeStamp");
            time.setAccessible(true);
            Field name = Post.class.getDeclaredField("userID");
            name.setAccessible(true);

            Post post = new Post();
            //make every other test using various asserts and such.

            assertEquals(post.getImage(), "null");
            assertEquals(post.getMessage(), "blank");
            assertEquals(post.getTags(), "null");
            assertEquals(post.getTimeStamp(), -1);
            assertEquals(post.getUserID(), -1);
            //simple tests of everything is happy and works
            //NOW WE DO SOME WEIRD STUFF
            //test default constructor, using equals.
        }
        catch (Exception e) {
            assertTrue(false);
        }
    }
    //maybe test handling a picture, we don't know how to do that yet...
}
