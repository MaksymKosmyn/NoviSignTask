package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.models.ProjectStatus;
import com.novisign.task.API.Service.entity.Project;
import com.novisign.task.API.Service.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.logging.Logger;

@TestPropertySource(locations = "classpath:project-controller-test.properties")
public abstract class AbstractUserControllerTest {

    protected static final String FULL_NAME = "USER_FULL_NAME";
    protected static final String LOGIN_NAME = "USER_LOGIN_NAME";
    protected static final String PASSWORD = "PASSWORD";
    protected static final Project PROJECT = new Project(FULL_NAME, ProjectStatus.PENDING);

    @Autowired
    UsersController usersController;

    @Test
    public void validUserName(){
        Logger.getGlobal().info("Start validUserName test");
        User user = usersController.findByName(LOGIN_NAME);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(LOGIN_NAME, user.getLoginName());
        Logger.getGlobal().info("End validUserName test");
    }

}
