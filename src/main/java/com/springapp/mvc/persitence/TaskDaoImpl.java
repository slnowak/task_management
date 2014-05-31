package com.springapp.mvc.persitence;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.persitence.generic.GenericDaoImpl;
import org.springframework.stereotype.Repository;


/**
 * Created by novy on 31.05.14.
 */

@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements TaskDao {
    protected TaskDaoImpl() {
        super(Task.class);
    }
}
