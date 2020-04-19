package com.app.api.domain.like.support;

import com.app.api.domain.like.Like;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class LikeSupportImpl extends QuerydslRepositorySupport  implements LikeSupport {

    private final JpaRepositoryFactory jpaRepositoryFactory;

    public LikeSupportImpl( JpaRepositoryFactory jpaRepositoryFactory) {
        super(Like.class);
        this.jpaRepositoryFactory = jpaRepositoryFactory;
    }

}
