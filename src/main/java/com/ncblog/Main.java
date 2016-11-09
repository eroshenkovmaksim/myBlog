package com.ncblog;

import com.ncblog.dataaccess.repositories.*;
import com.ncblog.dataaccess.specifications.users.UserWhich;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import org.hibernate.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 04.11.2016
 */
public class Main {
    public static void main(String args[]) {
        User ura = new User("Minin", "yura");
        User max = new User("Max","krasava");
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        Post_LikeRepository post_likeRepository = new Post_LikeRepository();
        CommentRepository commentRepository = new CommentRepository();
//
        Post post = new Post("privetik");
        Post post2 = new Post("aloha");
        userRepository.add(ura);
        userRepository.add(max);
        postRepository.addPostToUser(post, ura);
        postRepository.addPostToUser(post2,ura);
        postRepository.addPostToUser(post2,ura);
        post_likeRepository.addLikeToPostByUser(max,post);
        post_likeRepository.addLikeToPostByUser(ura,post);
        post_likeRepository.addLikeToPostByUser(max,post);
        post_likeRepository.addLikeToPostByUser(max,post);
//
        Comment comment = new Comment("nice");
        commentRepository.addCommentToPostByUser(max,post,comment);
        commentRepository.addCommentToPostByUser(max,post2,comment);
        commentRepository.addCommentToPostByUser(ura,post,comment);
        commentRepository.addCommentToPostByUser(max,post,comment);
//
////
////        System.out.print("ura's 1st post got ");
////        System.out.print(post.getPosts_likes().size());
////        System.out.println(" likes");
//
        List<User> yras = userRepository.getEvery(UserWhich.hasLogin("Max"));
//        List<User> yras = userRepository.getAll();
        for(User yra : yras) {
            System.out.println(yra.getUser_id());
        }
//        Collection<Post> posts =ura.getPosts();
//        for(Post p: posts) {
//            System.out.println(p.getContent());
//        }

    }
}
