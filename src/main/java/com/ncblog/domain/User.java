package com.ncblog.domain;


import javax.persistence.*;
import java.util.*;

/**
 * Created by Администратор on 02.11.2016.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name="seq-gen", sequenceName="USERS_USER_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column (name = "REGISTRATION_DATE")
    private Date registration_date;

    @OneToMany(mappedBy="user",targetEntity=Post.class, fetch=FetchType.EAGER)
    Collection<Post> posts = new HashSet();

    @OneToMany(mappedBy="user",targetEntity=Post_Like.class, fetch=FetchType.EAGER)
    Set<Post_Like> posts_likes = new HashSet<>();

    @OneToMany(mappedBy="user",targetEntity=Comment.class, fetch=FetchType.EAGER)
    Set<Comment> comments = new HashSet<>();
//    private String first_name;
//    private String last_name;
//    private char gender;
//    private int age;
//    private String email;
//    private URL avatar;

//    private int number_of_posts;
//    private String access_level;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.registration_date = new Date();
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

    public Date getRegistration_date() {
        return registration_date;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public void setPost(Post post) {
        posts.add(post);
    }

    public int getUser_id() {
        return user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
