package com.ncblog.domain;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Администратор on 02.11.2016.
 */
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID", unique = true, nullable = false)
    private int post_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName = "USER_ID")
    private User user;

    @Column (name = "CONTENT")
    private String content;

    @Column (name = "CREATION_DATE")
    private Date creation_date;

//    @OneToMany(mappedBy="post", targetEntity=Post_Like.class, fetch=FetchType.EAGER)
//    Set<Post_Like> posts_likes = new HashSet<>();
//
//    @OneToMany(mappedBy="post",targetEntity=Comment.class, fetch=FetchType.EAGER)
//    Set<Comment> comments = new HashSet<>();

    public Post() {
    }

    public Post(String content) {
        this.content = content;
        this.creation_date = new Date();

    }

//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }
//
//    public Set<Post_Like> getPosts_likes() {
//        return posts_likes;
//    }
//
//    public void setPosts_likes(Set<Post_Like> posts_likes) {
//        this.posts_likes = posts_likes;
//    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreation_date() {
        return creation_date;
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
