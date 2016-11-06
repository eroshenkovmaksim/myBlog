package com.ncblog.dataaccess.specifications.users;


import com.ncblog.dataaccess.specifications.AbstractWhich;
import com.ncblog.dataaccess.specifications.Specification;
import com.ncblog.domain.User;

/**
 * Created by ivan on 02.11.16.
 */
public class UserWhich extends AbstractWhich<User> {

    public UserWhich() {
    }

    public static Specification<User> hasLogin(String login){
        return new hasLogin(login);
    }
}
