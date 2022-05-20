package com.novisign.task.API.Service.entity;

import com.novisign.task.API.Service.models.ProjectStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

    private static final long serialVersionUID = 1;

    public static Long nextId = 0L;

    @Id
    protected Long id;

    @Column(name = "name")
    protected String name;

    @Column(name = "status")
    protected String status;

    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }

    protected Project() {
        id = getNextId();
    }

    public Project(final String name, final ProjectStatus status) {
        id = getNextId();
        this.name = name;
        this.status = status.name();
    }

    @Override
    public String toString() {
        return "Project name -> " + name + " Project status -> " + status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
