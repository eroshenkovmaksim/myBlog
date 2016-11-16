package com.ncblog.dataaccess.specifications.users;

import com.ncblog.dataaccess.specifications.AbstractWhich;
import com.ncblog.dataaccess.specifications.Specification;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 17.11.2016.
 */
public class CommentWhich extends AbstractWhich<Comment> {

    public CommentWhich() {
    }

    public static Specification<Comment> belongsToPost(int user_id){
        return new belongsToPost(user_id);
    }
}