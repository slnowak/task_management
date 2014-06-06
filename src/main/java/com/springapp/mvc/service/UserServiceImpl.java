package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.UserDao;
import com.springapp.mvc.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by novy on 07.06.14.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserDao, User, String>
        implements UserService {
    @Autowired
    public UserServiceImpl(UserDao dao) {
        super(dao);
    }
}
