package com.ncblog.web;

/**
 * Created by Администратор on 28.11.2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ncblog.dataaccess.repositories.PostRepository;
import com.ncblog.dataaccess.repositories.UserRepository;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Spark;

import static spark.Spark.*;

public class WebBlog {

    public static void main(String args[]) {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        get("/status", ((request, response) -> {
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.html");
        }), new FreeMarkerEngine());
        get("/registration", ((request, response) -> {
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "registration.html");
        }), new FreeMarkerEngine());

//        get("/personalpage", ((request, response) -> {
//            HashMap<Object, Object> model = new HashMap<>();
//            return new ModelAndView(model, "registration.html");
//        }), new FreeMarkerEngine());

        post("/registration", (request, response) -> {
            String login = request.queryParams("login");
            String password = request.queryParams("password");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", login);
            User user =new User(login, password);
            userRepository.add(user);
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.html");

        },new FreeMarkerEngine());

        post("/login", (request, response) -> {
            String login = request.queryParams("login");
            String password = request.queryParams("password");
            Map<String, Object> attributes = new HashMap<>();
            User user =userRepository.getUserWithLogin(login);
            String value = request.queryParams("button");
            if("Sign In".equalsIgnoreCase(value)){
                if (user != null && (user.getPassword()).equals(password)) {
                    List<String> contents = new ArrayList<String>();
                    List<Post> posts = postRepository.getUserPosts(login);
                    for (Post post : posts) {
                        contents.add(post.getContent());
                    }
                    attributes.put("login", login);
                    attributes.put("contents", contents);
//                attributes.put("date", posts);
//                    response.body("123");
//                    response.redirect("/personalpage");
                    return new ModelAndView(attributes, "personalPage.html");
                } else {
                    System.out.println("wrong password");
                    HashMap<Object, Object> model = new HashMap<>();
                    return new ModelAndView(model, "loginv2.html");
                }
            }else{
                response.redirect("/registration");
                return null;
            }
        },new FreeMarkerEngine());
    }

}