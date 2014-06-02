package com.springapp.mvc.service;

import com.springapp.mvc.model.Task;

import java.util.Collection;
import java.util.List;

/**
 * Created by novy on 31.05.14.
 */
public interface TaskService {
    public void createTask(Task task);
    public void updateTask(Task task);
    public void deleteTask(Integer taskId);
    public Task getTask(Integer taskId);
    public List<Task> getAllTasks();
    public List<Task> findByUsername(String username);
}
