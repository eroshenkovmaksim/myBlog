package com.ncblog.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;

/**
 * Created by Администратор on 02.11.2016.
 */
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @SequenceGenerator(name="seq-gen", sequenceName="POSTS_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    @Column(name = "POST_ID")
    private int post_id;


    private int user_id;

    @Column (name = "CONTENT")
    private String content;

//    private Data creation_date;
//    private int likes;
//    private int comments;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
