package com.ncblog.web;

/**
 * Created by Администратор on 28.11.2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ncblog.dataaccess.repositories.CommentRepository;
import com.ncblog.dataaccess.repositories.PostRepository;
import com.ncblog.dataaccess.repositories.UserRepository;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Spark;

import static spark.Spark.*;

public class WebBlog {
    static Map<String,User> userSessions = new HashMap<>();
    static Map<String,Post> postSessions = new HashMap<>();
    public static void main(String args[]) {
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        CommentRepository commentRepository = new CommentRepository();

        get("/status", ((request, response) -> {
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.html");
        }), new FreeMarkerEngine());

        get("/registration", ((request, response) -> {
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "registration.html");
        }), new FreeMarkerEngine());



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
            User user =userRepository.getUserWithLogin(login);
            String value = request.queryParams("button");
            if("Sign In".equalsIgnoreCase(value)){
                if (user != null && (user.getPassword()).equals(password)) {
                    userSessions.put(request.session().id(),user);
                    response.redirect("/personalpage");
                    return null;
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

        get("/personalpage", ((request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String currentSession = request.session().id();
            if(userSessions.containsKey(currentSession)){
                User user = userSessions.get(currentSession);
                String login = user.getLogin();
                List<Post> posts = postRepository.getUserPosts(login);
                attributes.put("login", login);
                attributes.put("posts", posts);
                return new ModelAndView(attributes, "personalPage.html");
            }
            response.redirect("/login");
            return null;
        }), new FreeMarkerEngine());

        post("/personalpage", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String currentSession = request.session().id();
            System.out.println(currentSession);
            if(userSessions.containsKey(currentSession)){
                User user = userSessions.get(currentSession);
                String login = user.getLogin();
                List<Post> posts = postRepository.getUserPosts(login);
                for(Post post : posts){
                    String value = request.queryParams(post.getContent());

                    if("Comments".equalsIgnoreCase(value)){
                        postSessions.put(currentSession,post);
                        response.redirect("/comments");
                    }
                }
            }
            return null;
        },new FreeMarkerEngine());

        get("/comments", ((request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String currentSession = request.session().id();
            if(postSessions.containsKey(currentSession)){
                Post post = postSessions.get(currentSession);
                List<Comment> comments = commentRepository.getPostComments(post);
                attributes.put("post", post.getContent());
                attributes.put("comments", comments);
                return new ModelAndView(attributes, "comments.html");
            }
            return null;
        }), new FreeMarkerEngine());
    }

}