package com.novisign.task.API.Service.service;

import com.novisign.task.API.Service.entity.Project;

import java.util.List;

public interface ProjectsService {

    public List<Project> retriveAllProjects();

    public Project findProjectByStatus(String status);

    public Project findProjectByName(String name);

    public Project createProject(Project user);

    public void deleteProjectByName(String name);
}
