package com.ncblog.dataaccess.specifications.users;

import com.ncblog.dataaccess.specifications.AbstractWhich;
import com.ncblog.dataaccess.specifications.Specification;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 17.11.2016.
 */
public class PostWhich extends AbstractWhich<Post> {

    public PostWhich() {
    }

    public static Specification<Post> belongsToUser(int user_id){
        return new belongsToUser(user_id);
    }
}