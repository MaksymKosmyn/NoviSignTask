package com.novisign.task.API.Service.repositories;

import com.novisign.task.API.Service.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query("SELECT u FROM Project as u WHERE u.fullName =?1 ")
    Project findByName(String fullName);

    @Query("SELECT u FROM Project as u WHERE u.loginName =?1")
    Project findByStatus(String loginName);

    @Override
    @Query("SELECT u FROM Project as u")
    List<Project> findAll();

    @Query("SELECT count(*) from Project ")
    public int countProjects();

}
