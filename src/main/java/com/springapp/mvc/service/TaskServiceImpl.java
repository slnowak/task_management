package com.springapp.mvc.service;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.model.User;
import com.springapp.mvc.persitence.TaskDao;
import com.springapp.mvc.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by novy on 06.06.14.
 */
@Service
public class TaskServiceImpl extends GenericServiceImpl<TaskDao, Task, Integer> implements TaskService {
    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        super(taskDao);
    }

    @Override
    public List<Task> findByUser(User user) {
        return dao.findByUser(user);
    }
}
