package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

/**
 * Created by novy on 01.06.14.
 */
public interface UserService {
    public void createUser(User user);
    public void updateUser(User user);
    public User getUser(String username);
    public void deleteUser(String username);
}
