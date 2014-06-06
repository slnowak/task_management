package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.UserRoleDao;
import com.springapp.mvc.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by novy on 07.06.14.
 */
@Service
public class UserRoleServiceImpl extends GenericServiceImpl<UserRoleDao, UserRole, Integer>
        implements UserRoleService {
    @Autowired
    public UserRoleServiceImpl(UserRoleDao dao) {
        super(dao);
    }

    @Override
    public List<UserRole> getUserRolesByUser(User user) {
        return dao.getByUser(user);
    }
}
