package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.entity.User;
import com.novisign.task.API.Service.exception.UserNotFoundException;
import com.novisign.task.API.Service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
public class UsersController {

    protected Logger logger = Logger.getLogger(UsersController.class
            .getName());

    protected UserRepository userRepository;

    @Autowired
    public UsersController(final UserRepository userRepository) {
        this.userRepository = userRepository;

        logger.info("ProjectRepository says system has " + userRepository.countUsers() + "users");
    }

    @GetMapping(path = "/users/login/{login}")
    public User findByName(@PathVariable("login") String login) {
        logger.info("API-service users findByName() invoked: " + login);

        User user = userRepository.findByLoginName(login);

        logger.info("API-service users findByName() found: " + user);

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("Login -> " + login);
        } else {
            return user;
        }
    }

    @GetMapping(path = "/users/remove/{login}")
    public User deleteUserByLogin(@PathVariable("login") String login){
        logger.info("API-service users deleteUserByLogin() invoked: " + login);

        final User userToDelete = userRepository.findByLoginName(login);
        User user = userRepository.delete(userToDelete);

        logger.info("API-service users deleteUserByLogin() found: " + user);

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("Login -> " + login);
        } else {
            return user;
        }
    }

    @PostMapping(path = "/users/create")
    public User createUser(@RequestBody User user){
        logger.info("API-service users createUser() invoked");

        final User savedUser = userRepository.save(user);

        logger.info("API-service users createUser() create a user: " + savedUser.getLoginName());

        if (Objects.isNull(savedUser)) {
            throw new UserNotFoundException("User did not created");
        } else {
            return savedUser;
        }
    }


}
