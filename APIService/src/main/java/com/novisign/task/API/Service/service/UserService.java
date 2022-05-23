package com.novisign.task.API.Service.service;

import com.novisign.task.API.Service.entity.User;

import java.util.List;

public interface UserService {

    public List<User> retriveAllUsers();

    public User findUserByLoginName(String loginName);

    public List<User> findUsersByFullName(String fullName);

    public User createUser(User user);

    public void deleteUserByLoginName(String loginName);

}
