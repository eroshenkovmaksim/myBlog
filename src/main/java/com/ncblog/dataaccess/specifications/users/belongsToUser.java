package com.ncblog.dataaccess.specifications.users;

import com.ncblog.dataaccess.specifications.AbstractSpecification;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Администратор on 17.11.2016.
 */
public class belongsToUser extends AbstractSpecification<Post> {
    private int user_id;

    belongsToUser(int user_id) {
        this.user_id = user_id;
    }

    public boolean isSatisfiedBy(Post post) {
        return post.getUser().getUser_id() == this.user_id;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("user.user_id", this.user_id);
    }

}
