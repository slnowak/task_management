package com.springapp.mvc.persitence;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.generic.GenericDao;

import java.util.Collection;
import java.util.List;

/**
 * Created by novy on 02.06.14.
 */
public interface UserRoleDao extends GenericDao<UserRole, Integer> {
    public List<UserRole> getByUser(User user);
}
