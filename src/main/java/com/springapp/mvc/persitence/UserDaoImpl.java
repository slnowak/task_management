package com.springapp.mvc.persitence;

import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.generic.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by novy on 01.06.14.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
