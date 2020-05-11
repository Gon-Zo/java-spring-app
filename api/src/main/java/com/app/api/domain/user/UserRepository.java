package com.app.api.domain.user;

import com.app.api.enums.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Page<User> findAll( Pageable pageable);

    User findByEmail(String email);

}
