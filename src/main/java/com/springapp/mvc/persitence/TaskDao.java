package com.springapp.mvc.persitence;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.persitence.generic.GenericDao;

/**
 * Created by novy on 31.05.14.
 */
public interface TaskDao extends GenericDao<Task, Integer> {
}
