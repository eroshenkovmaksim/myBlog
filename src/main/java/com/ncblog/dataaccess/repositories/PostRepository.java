package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.Post;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 06.11.2016.
 */
public class PostRepository extends GenericRepository<Post> {
    public PostRepository() {
        super(Post.class);
    }
    public void addPostToUser(Post post,User user){

        post.setUser(user);
//        user.getPosts().add(post);
        this.add(post);
    }
}
