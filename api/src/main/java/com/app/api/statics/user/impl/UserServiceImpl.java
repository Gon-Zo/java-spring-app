package com.app.api.statics.user.impl;

import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepository;
import com.app.api.statics.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserRepositorySuportImpl userRepositorySuport;

    public UserServiceImpl(UserRepository repository, UserRepositorySuportImpl userRepositorySuport) {
        this.repository = repository;
        this.userRepositorySuport = userRepositorySuport;
    }

    @Override
    public User getUser(String title) {
        return userRepositorySuport.findByTitle(title);
    }

    @Override
    public List<User> allUser() {
        return repository.findAll();
    }

}
