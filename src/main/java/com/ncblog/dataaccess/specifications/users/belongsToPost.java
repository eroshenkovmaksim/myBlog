package com.ncblog.dataaccess.specifications.users;

import com.ncblog.dataaccess.specifications.AbstractSpecification;
import com.ncblog.dataaccess.specifications.Specification;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Администратор on 17.11.2016.
 */
public class belongsToPost extends AbstractSpecification<Comment> {
    private int post_id;

    belongsToPost(int user_id) {
        this.post_id = user_id;
    }

    public boolean isSatisfiedBy(Comment comment) {
        return comment.getPost().getPost_id() == this.post_id;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("post.post_id", this.post_id);
    }

}
