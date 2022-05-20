package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.exception.ProjectNotFoundException;
import com.novisign.task.API.Service.models.ProjectStatus;
import com.novisign.task.API.Service.entity.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.logging.Logger;

@TestPropertySource(locations = "classpath:project-controller-test.properties")
public abstract class AbstractProjectControllerTest {

    protected static final String PROJECT_NAME = "Project1";
    protected static final ProjectStatus PROJECT_STATUS = ProjectStatus.ACTIVE;

    @Autowired
    ProjectsController projectController;

    @Test
    public void validProjectName() {
        Logger.getGlobal().info("Start validProjectName test");
        Project project = projectController.findByName(PROJECT_NAME);

        Assertions.assertNotNull(project);
        Assertions.assertEquals(PROJECT_NAME, project.getName());
        Logger.getGlobal().info("End validProjectName test");
    }

    @Test
    public void validProjectStatus() {
        Logger.getGlobal().info("Start validProjectStatus test");
        List<Project> project = projectController.findByStatus(PROJECT_STATUS.name());

        Assertions.assertNotNull(project);
        Assertions.assertEquals(PROJECT_STATUS.name(), project.get(0).getStatus());
        Logger.getGlobal().info("End validProjectStatus test");
    }


    @Test
    public void invalidProjectName() {
        try {
            projectController.findByName("10101010");
            Assertions.fail("Expected an ProjectNotFoundException");
        } catch (ProjectNotFoundException e) {
            // Worked!
        }
    }

    @Test
    public void invalidProjectStatus() {
        try {
            projectController.findByStatus("EXPIRED");
            Assertions.fail("Expected an ProjectNotFoundException");
        } catch (ProjectNotFoundException e) {
            // Worked!
        }
    }
}
