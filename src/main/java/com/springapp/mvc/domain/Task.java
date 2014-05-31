package com.springapp.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by novy on 31.05.14.
 */

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private Boolean done;

    private Task() {}

    public Task(String name, String description, Boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
