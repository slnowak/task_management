package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.UserRoleDao;
import com.springapp.mvc.service.generic.GenericService;

import java.util.List;

/**
 * Created by novy on 07.06.14.
 */
public interface UserRoleService extends GenericService<UserRoleDao, UserRole, Integer> {
    public List<UserRole> getUserRolesByUser(User user);
}
