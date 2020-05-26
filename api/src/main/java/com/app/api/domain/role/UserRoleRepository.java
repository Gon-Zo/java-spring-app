package com.app.api.domain.role;

import com.app.api.domain.role.UserRole;
import com.app.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole , Long> {

    void deleteByUserSeq(long user);

    List<UserRole> findByUserSeq(long seq);

}
