package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by novy on 01.06.14.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public User getUser(Integer taskId) {
        return userDao.getByPrimaryKey(taskId);
    }

    @Override
    public void deleteUser(Integer taskId) {
        User user = getUser(taskId);
        userDao.delete(user);
    }
}
