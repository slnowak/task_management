package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by novy on 01.06.14.
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private Collection<Task> tasks = new LinkedList<>(); // FIX IT

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new LinkedList<>();

    public User(String username, String password, String firstName, String lastName, Boolean active,
                Collection<Task> tasks, List<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.tasks = tasks;
        this.userRoles = userRoles;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addRole(UserRole userRole) {
        userRoles.add(userRole);
    }
}
