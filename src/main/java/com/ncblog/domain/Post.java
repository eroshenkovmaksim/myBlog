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
    @SequenceGenerator(name="seq-gen2", sequenceName="POSTS_POST_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen2")
    @Column(name = "POST_ID")
    private int post_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
    private User user;
//    private int user_id;

    @Column (name = "CONTENT")
    private String content;

    @Column (name = "CREATION_DATE")
    private Date creation_date;

    @OneToMany(mappedBy="post",targetEntity=Post_Like.class, fetch=FetchType.EAGER)
    Set<Post_Like> posts_likes = new HashSet<>();

    @OneToMany(mappedBy="post",targetEntity=Comment.class, fetch=FetchType.EAGER)
    Set<Comment> comments = new HashSet<>();

    public Post() {
    }

    public Post(String content) {
        this.content = content;
        this.creation_date = new Date();

    }


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post_Like> getPosts_likes() {
        return posts_likes;
    }

    public void setPosts_likes(Set<Post_Like> posts_likes) {
        this.posts_likes = posts_likes;
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
