package com.springapp.mvc.service;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.persitence.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by novy on 31.05.14.
 */
@Service
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void createTask(Task task) {
        taskDao.create(task);
    }

    @Override
    public void updateTask(Task task) {
        taskDao.update(task);
    }

    @Override
    public Task getTask(Integer id) {
        return taskDao.getByPrimaryKey(id);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskDao.getAll();
    }
}
