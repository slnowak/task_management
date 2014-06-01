package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
    private Collection<Task> tasks;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<>();

    public User(String username, String password, String firstName, String lastName, Boolean active,
                Collection<Task> tasks, Set<UserRole> userRole) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.tasks = tasks;
        this.userRole = userRole;
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

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
