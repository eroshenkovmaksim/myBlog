package com.ncblog.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 02.11.2016.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name="seq-gen", sequenceName="USERS_ID_SEQ", initialValue=205, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    @Column(name = "ID")
    private int user_id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

//    @OneToMany
//    List<Post> posts = new ArrayList<>();

//    private String first_name;
//    private String last_name;
//    private char gender;
//    private int age;
//    private String email;
//    private URL avatar;
//    private Date registarion_date;
//    private int number_of_posts;
//    private String access_level;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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
