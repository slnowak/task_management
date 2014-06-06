package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.UserDao;
import com.springapp.mvc.service.generic.GenericService;

/**
 * Created by novy on 07.06.14.
 */
public interface UserService extends GenericService<UserDao, User, String> {
}
