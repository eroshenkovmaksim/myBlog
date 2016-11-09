package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 06.11.2016.
 */
public class CommentRepository extends GenericRepository<Comment> {
    public CommentRepository() {
        super(Comment.class);
    }
    public void addCommentToPostByUser(User user, Post post, Comment comment){

        comment.setUser(user);
        comment.setPost(post);
//        user.getComments().add(comment);
//        post.getComments().add(comment);
        this.add(comment);
    }
}
