package com.novisign.task.API.Service.service.impl;

import com.novisign.task.API.Service.entity.User;
import com.novisign.task.API.Service.repositories.UserRepository;
import com.novisign.task.API.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    public List<User> findUsersByFullName(String fullName) {
        return userRepository.findByFullName(fullName);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByLoginName(String loginName) {
        final User user = userRepository.findByLoginName(loginName);
        userRepository.delete(user);
    }
}
