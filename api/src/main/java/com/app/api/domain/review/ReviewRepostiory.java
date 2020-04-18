package com.app.api.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepostiory extends JpaRepository<Review, Long> {
}
