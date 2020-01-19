package com.app.api.statics.user.impl;

import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepository;
import com.app.api.statics.user.UserRepositorySupport;
import com.app.api.statics.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserRepositorySupport userRepositorySupport;

    public UserServiceImpl(UserRepository repository, UserRepositorySupport userRepositorySupport) {
        this.repository = repository;
        this.userRepositorySupport = userRepositorySupport;
    }

    @Override
    public User getUser(String title) {
        return userRepositorySupport.findByTitle(title);
    }

    @Override
    public List<User> allUser() {
        return repository.findAll();
    }

}
