package com.novisign.task.API.Service.repositories;

import com.novisign.task.API.Service.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {

    public User findByLoginName(String name);

    public User save(User user);

    public User delete(User user);

    @Query("SELECT count(*) from User ")
    public int countUsers();
}
