package com.app.api.statics.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorySupport {

    User findByTitle(String title);

}
