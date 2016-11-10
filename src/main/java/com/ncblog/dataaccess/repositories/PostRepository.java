package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.Post;
import com.ncblog.domain.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 06.11.2016.
 */
public class PostRepository extends GenericRepository<Post> {
    Set<Post> posts = new HashSet();
    public PostRepository() {
        super(Post.class);
    }
    public void addPostToUser(Post post,User user){
        if(posts.contains(post)){
            this.update(post);
        }else {
            post.setUser(user);
            this.add(post);
        }
        posts.add(post);
    }
}
