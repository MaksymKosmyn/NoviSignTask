package com.novisign.task.API.Service.service.impl;

import com.novisign.task.API.Service.entity.Project;
import com.novisign.task.API.Service.repositories.ProjectRepository;
import com.novisign.task.API.Service.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> retriveAllProjects() {
        return projectRepository.findAll();
    }


    @Override
    public Project findProjectByStatus(String status) {
        return projectRepository.findByStatus(status);
    }

    @Override
    public Project findProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectByName(String name) {
        final Project project = projectRepository.findByName(name);
        projectRepository.delete(project);
    }
}
