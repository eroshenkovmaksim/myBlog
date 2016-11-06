package com.ncblog.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Администратор on 02.11.2016.
 */
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @SequenceGenerator(name="seq-gen4", sequenceName="COMMENTS_COMMENT_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen4")
    @Column(name = "COMMENT_ID")
    private int comment_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="POST_ID",referencedColumnName="POST_ID")
    private Post post;

    @Column (name = "COMMENT")
    private String comment;

    @Column (name = "CREATION_DATE")
    private Date creation_date;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
        this.creation_date = new Date();

    }


    public int getComment_id() {
        return comment_id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreation_date() {
        return creation_date;
    }


}
