package com.ncblog.dataaccess.repositories;

import com.ncblog.domain.User;

/**
 * Created by Администратор on 06.11.2016.
 */
public class UserRepository extends GenericRepository<User> {
    public UserRepository() {
        super(User.class);
    }
}
