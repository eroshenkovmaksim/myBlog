package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.Post;
import com.ncblog.domain.Post_Like;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 06.11.2016.
 */
public class Post_LikeRepository extends GenericRepository<Post_Like> {
    public Post_LikeRepository() {
        super(Post_Like.class);
    }
    public void addLikeToPostByUser(User user, Post post){

        Post_Like pl = new Post_Like(user, post);
        user.getPosts_likes().add(pl);
        post.getPosts_likes().add(pl);
        this.add(pl);
    }
}