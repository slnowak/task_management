package com.springapp.mvc.model;

import javax.persistence.*;

/**
 * Created by novy on 01.06.14.
 */

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole {
    @Id
    @GeneratedValue
    private Integer userRoleId;
    private String role;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public UserRole(String role, User user) {
        this.role = role;
        this.user = user;
    }

    public UserRole() {}

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
