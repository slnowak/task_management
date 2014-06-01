package com.springapp.mvc.service;

import com.springapp.mvc.model.Task;

import java.util.Collection;

/**
 * Created by novy on 31.05.14.
 */
public interface TaskService {
    public void createTask(Task task);
    public void updateTask(Task task);
    public void deleteTask(Integer taskId);
    public Task getTask(Integer taskId);
    public Collection<Task> getAllTasks();
    public Collection<Task> findByUsername(String username);
}
