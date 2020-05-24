package com.app.api.domain.order;

import com.app.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {
    Order findByUser(User user);
}
