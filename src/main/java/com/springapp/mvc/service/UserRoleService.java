package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;

import java.util.List;

/**
 * Created by novy on 02.06.14.
 */
public interface UserRoleService {
    public void createUserRole(UserRole useRole);
    public void updateUserRole(UserRole userRole);
    public void deleteUserRole(Integer userRoleId);
    public UserRole getUserRoleByPrimaryKey(Integer userRoleId);
    public List<UserRole> getUserRolesByUser(User user);

}
