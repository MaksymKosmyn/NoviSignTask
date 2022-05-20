package com.novisign.task.API.Service.controllers;

import com.novisign.task.API.Service.entity.User;
import com.novisign.task.API.Service.repositories.UserRepository;

public class UsersControllerTest extends AbstractUserControllerTest {

    protected static final User theUser = new User(FULL_NAME, LOGIN_NAME, PASSWORD, PROJECT);

    protected static class TestUserRepository implements UserRepository {

        @Override
        public User findByLoginName(String name) {
            if (name.equals(LOGIN_NAME))
                return theUser;
            else
                return null;
        }

        @Override
        public User save(User user) {
            return user;
        }

        @Override
        public User delete(User user) {
            return user;
        }

        @Override
        public int countUsers() {
            return 1;
        }
    }

}
