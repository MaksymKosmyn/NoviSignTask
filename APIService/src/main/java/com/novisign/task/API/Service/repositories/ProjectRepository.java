package com.novisign.task.API.Service.repositories;

import com.novisign.task.API.Service.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProjectRepository extends Repository<Project, Long> {

    public Project findByName(String name);

    public List<Project> findByStatus(String status);

    public Project save(Project project);

    public Project delete(Project project);

    @Query("SELECT count(*) from Project ")
    public int countProjects();

}
