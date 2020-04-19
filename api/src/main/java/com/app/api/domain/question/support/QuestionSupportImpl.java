package com.app.api.domain.question.support;

import com.app.api.domain.question.Question;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class QuestionSupportImpl extends QuerydslRepositorySupport implements QusetionSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager  entityManager;

    public QuestionSupportImpl( JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Question.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }
}
