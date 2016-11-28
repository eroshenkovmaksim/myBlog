package com.ncblog.web;

/**
 * Created by Администратор on 28.11.2016.
 */

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebBlog {

    public static void main(String args[]) {

        get("/status", ((request, response) -> {
            HashMap<Object, Object> model = new HashMap<>();
            return new ModelAndView(model, "login.html");
        }), new FreeMarkerEngine());

        post("/login", (request, response) -> {
            String login = request.queryParams("login");
            String password = request.queryParams("password");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", login);

            return new ModelAndView(attributes, "status.ftl");
        },new FreeMarkerEngine());
    }

}