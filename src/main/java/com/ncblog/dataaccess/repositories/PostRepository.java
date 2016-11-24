package com.ncblog.dataaccess.repositories;

import com.ncblog.dataaccess.specifications.users.PostWhich;
import com.ncblog.dataaccess.specifications.users.UserWhich;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

import java.util.HashSet;
import java.util.List;
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
    public List<Post> getPostsByUserWithLogin(String login){
        UserRepository userRepository = new UserRepository();
        int id = userRepository.getOne(UserWhich.hasLogin(login)).getUser_id();
        List<Post> posts= this.getEvery(PostWhich.belongsToUser(id));
        return posts;
    }
}
