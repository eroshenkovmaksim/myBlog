package com.ncblog.dataaccess.specifications.users;

import com.ncblog.dataaccess.specifications.AbstractSpecification;
import com.ncblog.domain.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class hasLogin extends AbstractSpecification<User> {

    private String login;

    hasLogin(String login) {
        this.login = login;
    }

    public boolean isSatisfiedBy(User user) {
        return user.getLogin() == this.login;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("login", this.login);
    }
}
