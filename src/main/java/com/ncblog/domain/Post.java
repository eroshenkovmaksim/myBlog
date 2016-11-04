package com.ncblog.domain;

import javax.xml.crypto.Data;

/**
 * Created by Администратор on 02.11.2016.
 */
public class Post {
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Data creation_date) {
        this.creation_date = creation_date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    private int post_id;
    private int user_id;
    private String content;
    private Data creation_date;
    private int likes;
    private int comments;
}
