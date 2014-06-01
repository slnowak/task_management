package com.springapp.mvc.persitence;

import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.generic.GenericDao;

/**
 * Created by novy on 01.06.14.
 */
public interface UserDao extends GenericDao<User, Integer> {
}
