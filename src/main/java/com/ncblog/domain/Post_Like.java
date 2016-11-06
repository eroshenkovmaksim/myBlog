package com.ncblog.domain;

import javax.persistence.*;

/**
 * Created by Администратор on 05.11.2016.
 */
@Entity
@Table(name = "POSTS_LIKES")
public class Post_Like {

    @Id
    @SequenceGenerator(name="seq-gen3", sequenceName="POSTS_LIKES_LIKE_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen3")
    @Column(name = "LIKE_ID")
    private int like_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="POST_ID",referencedColumnName="POST_ID")
    private Post post;

    public Post_Like() {
    }

    public Post_Like(User user, Post post) {
        this.user = user;
        this.post = post;
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
