package com.example.samplepage;

public class userData {
    String user_name;
    String last_active;
    String no_likes;
    String no_comments;
    String user_message;
    String user_profileimage;
    String post_image;

    public userData() {

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLast_active() {
        return last_active;
    }

    public void setLast_active(String last_active) {
        this.last_active = last_active;
    }

    public String getNo_likes() {
        return no_likes;
    }

    public void setNo_likes(String no_likes) {
        this.no_likes = no_likes;
    }

    public String getNo_comments() {
        return no_comments;
    }

    public void setNo_comments(String no_comments) {
        this.no_comments = no_comments;
    }

    public String getUser_message() {
        return user_message;
    }

    public void setUser_message(String user_message) {
        this.user_message = user_message;
    }

    public String getUser_profileimage() {
        return user_profileimage;
    }

    public void setUser_profileimage(String user_profileimage) {
        this.user_profileimage = user_profileimage;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public userData(String user_name, String last_active, String no_likes, String no_comments, String user_message, String user_profileimage, String post_image) {
        this.user_name = user_name;
        this.last_active = last_active;
        this.no_likes = no_likes;
        this.no_comments = no_comments;
        this.user_message = user_message;
        this.user_profileimage = user_profileimage;
        this.post_image = post_image;
    }
}
