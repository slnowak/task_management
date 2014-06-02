package com.springapp.mvc.model;

import javax.persistence.*;

/**
 * Created by novy on 01.06.14.
 */

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole {
    public static enum Role {
        ROLE_USER, ROLE_ADMIN;
    }

    @Id
    @GeneratedValue
    private Integer userRoleId;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public UserRole(Role role, User user) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleAsString() {
        return role.name();
    }
}
