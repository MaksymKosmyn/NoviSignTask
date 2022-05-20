package com.novisign.task.API.Service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1;

    public static Long nextId = 0L;

    @Id
    protected Long id;

    @Column(name = "full_name")
    protected String fullName;

    @Column(name = "login_name")
    protected String loginName;

    @Column(name = "password")
    protected String password;

//    @ElementCollection
//    @CollectionTable(
//            name="projects",
//            joinColumns=@JoinColumn(name="name")
//    )
//    protected List<Project> projects;

    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }

    protected User() {
        id = getNextId();
    }

    public User(final String fullName, final String loginName, final String password, final Project project) {
        id = getNextId();
        this.fullName = fullName;
        this.loginName = loginName;
        this.password = password;
//        this.projects.add(project);
    }

    @Override
    public String toString() {
        return "User full name -> " + fullName + " User projects -> ";

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setNextId(Long nextId) {
        User.nextId = nextId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
}
