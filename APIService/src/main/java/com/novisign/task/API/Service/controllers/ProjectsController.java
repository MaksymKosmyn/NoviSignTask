package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.entity.Project;
import com.novisign.task.API.Service.exception.ProjectNotFoundException;
import com.novisign.task.API.Service.exception.UserNotFoundException;
import com.novisign.task.API.Service.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
public class ProjectsController {

    protected Logger logger = Logger.getLogger(ProjectsController.class
            .getName());


    @Autowired
    private ProjectsService projectsService;

    @GetMapping(path = "/projects/name/{name}")
    public Project findByName(@PathVariable("name") String name) {
        logger.info("API-service projects findByName() invoked: " + name);

        Project project = projectsService.findProjectByName(name);

        logger.info("API-service projects findByName() found: " + project);

        if (Objects.isNull(project)) {
            throw new ProjectNotFoundException("Name -> " + name);
        } else {
            return project;
        }
    }

    @GetMapping(path = "/projects/status/{status}")
    public Project findByStatus(@PathVariable("status") String status) {
        logger.info("API-service projects findByStatus() invoked: " + status);

        Project project = projectsService.findProjectByStatus(status);

        logger.info("API-service projects findByStatus() found: " + project);

        if (Objects.isNull(project)) {
            throw new ProjectNotFoundException("Status - > " + status);
        } else {
            return project;
        }
    }

    @GetMapping(path = "/projects/remove/{name}")
    public ResponseEntity<Project> removeProject(@PathVariable("name") String name) {
        logger.info("API-service projects removeProject() invoked: " + name);

        projectsService.deleteProjectByName(name);

        logger.info("API-service projects removeProject() found: " + name);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(path = "/projects/create")
    public Project createProject(@RequestBody Project project) {
        logger.info("API-service projects createProject() invoked");

        final Project savedProject = projectsService.createProject(project);

        logger.info("API-service projects createProject() create a user: " + savedProject.getName());

        if (Objects.isNull(savedProject)) {
            throw new UserNotFoundException("Project did not created");
        } else {
            return savedProject;
        }
    }

}
