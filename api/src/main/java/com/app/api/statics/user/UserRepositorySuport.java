package com.app.api.statics.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorySuport {

    User findByTitle(String title);

}
