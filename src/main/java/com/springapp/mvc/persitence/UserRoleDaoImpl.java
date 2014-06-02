package com.springapp.mvc.persitence;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserRole;
import com.springapp.mvc.persitence.generic.GenericDaoImpl;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by novy on 02.06.14.
 */

@Repository
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole, Integer> implements UserRoleDao {
    public UserRoleDaoImpl() {
        super(UserRole.class);
    }

    @Override
    public List<UserRole> getByUser(User user) {
        Criterion criterion = Restrictions.eq("user", user);
        return findByCriterion(criterion);
    }
}
