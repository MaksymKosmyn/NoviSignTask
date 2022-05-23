package com.novisign.task.API.Service.repositories;

import com.novisign.task.API.Service.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT count(*) from User ")
    public int countUsers();

    @Query("SELECT u FROM User as u WHERE u.fullName =?1 ")
    List<User> findByFullName(String fullName);

    @Query("SELECT u FROM User as u WHERE u.loginName =?1")
    User findByLoginName(String loginName);

    @Override
    @Query("SELECT u FROM User as u")
    List<User> findAll();
}
