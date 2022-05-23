package com.novisign.task.API.Service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {

    private static final long serialVersionUID = 1;

    public static Long nextId = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String loginName;
    private String password;

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
}
