package com.ncblog.domain;


import javax.persistence.*;
import java.util.*;

/**
 * Created by Администратор on 02.11.2016.
 */

@Entity
@Table(name = "USERS")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    int user_id;

    @Column(name = "LOGIN",unique = true)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column (name = "REGISTRATION_DATE")
    private Date registration_date = new Date();

//    @OneToMany(mappedBy="user",targetEntity=Post.class, fetch=FetchType.EAGER)
//    Set<Post> posts = new HashSet();
//
//    @OneToMany(mappedBy="user",targetEntity=PostLike.class, fetch=FetchType.EAGER)
//    Set<PostLike> posts_likes = new HashSet<>();
//
//    @OneToMany(mappedBy="user",targetEntity=Comment.class, fetch=FetchType.EAGER)
//    Set<Comment> comments = new HashSet<>();
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

    }


//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }
//
//    public Set<PostLike> getPosts_likes() {
//        return posts_likes;
//    }
//
//    public void setPosts_likes(Set<PostLike> posts_likes) {
//        this.posts_likes = posts_likes;
//    }

//
//    public Set<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Post> posts) {
//        this.posts = posts;
//    }
//
//
//    public void setPost(Post post) {
//        posts.add(post);
//    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login.trim();
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
