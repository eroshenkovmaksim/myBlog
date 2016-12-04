package com.ncblog.dataaccess.repositories;

import com.ncblog.dataaccess.specifications.users.PostWhich;
import com.ncblog.dataaccess.specifications.users.UserWhich;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

import java.util.List;

/**
 * Created by Администратор on 06.11.2016.
 */
public class UserRepository extends GenericRepository<User> {
    public UserRepository() {
        super(User.class);
    }
    public User getUserWithLogin(String login){
        User user;
        try{
            user = this.getOne(UserWhich.hasLogin(login));
        }catch(javax.persistence.NoResultException e){
            System.out.println("wrong login");
            return null;
        }
        return user;
    }

}
