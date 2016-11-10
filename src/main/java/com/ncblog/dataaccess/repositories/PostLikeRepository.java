package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.Post;
import com.ncblog.domain.PostLike;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 06.11.2016.
 */
public class PostLikeRepository extends GenericRepository<PostLike> {
    public PostLikeRepository() {
        super(PostLike.class);
    }
    public void addLikeToPostByUser(User user, Post post){
        PostLike pl = new PostLike(user, post);
        this.add(pl);
    }
}