package com.app.api.statics.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUser(String title);
    List<User> allUser();
}
