package com.ncblog;

import com.ncblog.dataaccess.repositories.*;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

import java.util.List;

/**
 * Created by Администратор on 04.11.2016
 */
public class Main {
    public static void main(String args[]) {
        User ura = new User("Minin", "yuras");
        User max = new User("Max","krasava");
        UserRepository userRepository = new UserRepository();
        PostRepository postRepository = new PostRepository();
        PostLikeRepository post_likeRepository = new PostLikeRepository();
        CommentRepository commentRepository = new CommentRepository();
//
        Post post = new Post("privetik");
        Post post2 = new Post("aloha");
        userRepository.add(ura);
        userRepository.add(max);

        postRepository.addPostToUser(post, ura);
        postRepository.addPostToUser(post2,ura);
        post_likeRepository.addLikeToPostByUser(max,post);
        post_likeRepository.addLikeToPostByUser(ura,post);
        post_likeRepository.addLikeToPostByUser(max,post);
        post_likeRepository.addLikeToPostByUser(max,post);

        Comment comment = new Comment("nice");
        commentRepository.addCommentToPostByUser(max,post,comment);
        commentRepository.addCommentToPostByUser(max,post,comment);


//        List<User> yras = userRepository.getEvery(UserWhich.hasLogin("Max"));
        List<User> yras = userRepository.getAll();
        for(User yra : yras) {
            System.out.println(yra.getUser_id());
        }
//        Collection<Post> posts =ura.getPosts();
//        for(Post p: posts) {
//            System.out.println(p.getContent());
//        }

    }
}
