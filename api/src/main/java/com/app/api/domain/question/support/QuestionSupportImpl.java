package com.app.api.domain.question.support;

import com.app.api.domain.question.Question;
import com.app.api.utils.ApiDomainUtils;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.QustionResponseDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.app.api.domain.question.QQuestion.question;
import static com.app.api.utils.ApiDomainUtils.isNotEmpty;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Repository
public class QuestionSupportImpl extends QuerydslRepositorySupport implements QuestionSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager  entityManager;

    public QuestionSupportImpl( JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Question.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

    @Override
    public Page<Question> findByPage(PageableDto dto) {

        JPAQuery<Question> query = jpaQueryFactory
                .selectFrom(question);

        if (isNotEmpty(dto.getSort())) {
            query.orderBy(
                    ApiDomainUtils.getOrder(dto.getSort()).toArray(new OrderSpecifier[0])
            );
        }

        Pageable pageable = PageRequest.of(dto.getPage() , dto.getSize());

        query.limit(pageable.getPageSize()).offset(pageable.getOffset());

        QueryResults<Question> results = query.fetchResults();

        long total =  results.getTotal();

        List<Question> result = results.getResults();

        return new PageImpl<>( result , pageable , total);

    }

    @Override
    public void update(QustionResponseDto dto) {

        UpdateClause<JPAUpdateClause> updateQuery = update(question);

        if (isNotEmpty(dto.getTitle())){
            updateQuery.set(question.title , dto.getTitle());
        }

        if (isNotEmpty(dto.getContent())){
            updateQuery.set(question.content , dto.getContent());
        }

        if (isNotEmpty(dto.getIsLock())){
            updateQuery.set(question.isLock , dto.getIsLock());
        }

        updateQuery.execute();

    }


}
