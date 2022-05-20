package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.entity.Project;
import com.novisign.task.API.Service.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

public class ProjectsControllerTest extends AbstractProjectControllerTest{

    protected static final Project theProject = new Project(PROJECT_NAME,
            PROJECT_STATUS);

    protected static class TestProjectRepository implements ProjectRepository {


        @Override
        public Project findByName(String name) {
            if (name.equals(PROJECT_NAME))
                return theProject;
            else
                return null;
        }

        @Override
        public List<Project> findByStatus(String status) {
            if (status.equals(PROJECT_STATUS))
                return Collections.singletonList(theProject);
            else
                return null;
        }

        @Override
        public Project save(Project project) {
            return project;
        }

        @Override
        public Project delete(Project project) {
            return project;
        }


        @Override
        public int countProjects() {
            return 1;
        }
    }

    protected TestProjectRepository testRepo = new TestProjectRepository();

    @BeforeEach
    public void setup() {
        projectController = new ProjectsController(testRepo);
    }

}
