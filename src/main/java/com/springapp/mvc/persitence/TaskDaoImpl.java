package com.springapp.mvc.persitence;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.persitence.generic.GenericDaoImpl;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


/**
 * Created by novy on 31.05.14.
 */

@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements TaskDao {
    protected TaskDaoImpl() {
        super(Task.class);
    }

    @Override
    public List<Task> findByUsername(String username) {
        return findByCriterion(Restrictions.eq("username", username));
    }
}
