package com.ncblog.domain;

import javax.persistence.*;

/**
 * Created by Администратор on 05.11.2016.
 */
@Entity
@Table(name = "POSTS_LIKES")
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_ID", unique = true, nullable = false)
    private int like_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="POST_ID", referencedColumnName = "POST_ID")
    private Post post;

    public PostLike() {
    }

    public PostLike(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getLike_id() {
        return like_id;
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
