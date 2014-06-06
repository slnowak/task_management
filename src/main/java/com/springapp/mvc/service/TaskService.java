package com.springapp.mvc.service;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.TaskDao;
import com.springapp.mvc.service.generic.GenericService;

import java.util.List;

/**
 * Created by novy on 06.06.14.
 */
public interface TaskService extends GenericService<TaskDao, Task, Integer> {
    public List<Task> findByUser(User user);
}
