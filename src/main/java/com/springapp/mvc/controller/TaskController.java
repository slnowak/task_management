package com.springapp.mvc.controller;

import com.springapp.mvc.model.Task;
import com.springapp.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by novy on 31.05.14.
 */

@Controller
public class TaskController {
    private TaskService taskService;
    private final static String BINDING_RESULT_NAME = "org.springframework.validation.BindingResult.task";
    private final static String CREATE_BINDING_RESULT_FLASH_ATTRIBUTE_NAME = "taskCreateFormFlashAttribute";
    private final static String EDIT_BINDING_RESULT_FLASH_ATTRIBUTE_NAME = "taskEditFormFlashAttribute";

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listView(ModelMap modelMap) {
        modelMap.put("tasks", taskService.getAllTasks());
        return "task/list_view";
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.GET)
    public String createTask(@ModelAttribute("task") Task task, ModelMap modelMap) {
        if (modelMap.containsAttribute(CREATE_BINDING_RESULT_FLASH_ATTRIBUTE_NAME)) {
            modelMap.addAttribute(BINDING_RESULT_NAME, modelMap.get(CREATE_BINDING_RESULT_FLASH_ATTRIBUTE_NAME));
        }
        return "task/create_view";
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
    public String createTaskPost(@ModelAttribute("task") Task task, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(CREATE_BINDING_RESULT_FLASH_ATTRIBUTE_NAME, bindingResult);
            return "redirect:/tasks/add";
        }

        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/edit/{id}", method = RequestMethod.GET)
    public String editTask(@PathVariable("id") Integer taskId, @ModelAttribute("task") Task task, ModelMap modelMap) {
        Task editedTask = taskService.getTask(taskId);

        if (modelMap.containsAttribute(EDIT_BINDING_RESULT_FLASH_ATTRIBUTE_NAME)) {
            modelMap.put(BINDING_RESULT_NAME, modelMap.get(EDIT_BINDING_RESULT_FLASH_ATTRIBUTE_NAME));
        } else {
            modelMap.put("task", editedTask);
        }

        return "task/edit_view";
    }

    @RequestMapping(value = "/tasks/edit", method = RequestMethod.POST)
    public String editTask(@ModelAttribute("task") Task task, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(EDIT_BINDING_RESULT_FLASH_ATTRIBUTE_NAME, bindingResult);
            return "redirect:/tasks/edit/" + task.getId();
        }

        taskService.updateTask(task);
        redirectAttributes.addFlashAttribute("message", "Successfully updated task with id " + task.getId());
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/delete/{id}", method = RequestMethod.GET) // TODO: method should be DELETE
    public String deleteTask(@PathVariable("id") Integer taskId, ModelMap modelMap) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks";
    }

}
