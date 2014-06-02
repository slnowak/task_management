package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by novy on 02.06.14.
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleDao userRoleDao;

    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public void createUserRole(UserRole userRole) {
        userRoleDao.create(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleDao.update(userRole);
    }

    @Override
    public void deleteUserRole(Integer userRoleId) {
        UserRole userRole = getUserRoleByPrimaryKey(userRoleId);
        userRoleDao.delete(userRole);
    }

    @Override
    public UserRole getUserRoleByPrimaryKey(Integer userRoleId) {
        return userRoleDao.getByPrimaryKey(userRoleId);
    }

    @Override
    public List<UserRole> getUserRolesByUser(User user) {
        return userRoleDao.getByUser(user);
    }
}
