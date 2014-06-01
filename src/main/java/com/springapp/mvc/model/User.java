package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by novy on 01.06.14.
 */

@Entity
@Table(name = "user")
public class User {
    static enum Role {
        USER, ADMIN
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private Role role;


    @OneToMany(mappedBy = "user")
    private Collection<Task> tasks;

    public User(String username, String firstName, String lastName, Boolean active, Role role, Collection<Task> tasks) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.role = role;
        this.tasks = tasks;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }
}
