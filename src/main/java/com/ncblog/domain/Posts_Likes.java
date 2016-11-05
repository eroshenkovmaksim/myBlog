package com.ncblog.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Администратор on 05.11.2016.
 */
@Entity
@Table(name = "POSTS_LIKES")
public class Posts_Likes {

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="POST_ID",referencedColumnName="POST_ID")
    private Post post;

    public Posts_Likes() {
    }

    public Posts_Likes(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
