package com.ncblog.domain;

import javax.xml.crypto.Data;

/**
 * Created by Администратор on 02.11.2016.
 */
public class Comments {
    private int comment_id;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    private int post_id;
    private int user_id;
    private String comment;
    private Data creation_date;
    private int likes;
}
