package com.app.api.domain.notice.support;

import com.app.api.domain.notice.Notice;
import com.app.api.web.dto.NoticeResponseDto;
import com.app.api.web.dto.PageableDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.awt.*;
import java.util.List;

import static com.app.api.domain.notice.QNotice.notice;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Repository
public class NoticeSupportImpl extends QuerydslRepositorySupport implements NoticeSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public NoticeSupportImpl( JPAQueryFactory jpaQueryFactory) {
        super(Notice.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional
    public void update(NoticeResponseDto dto, long seq) {

        UpdateClause<JPAUpdateClause> update = update(notice);

        if(isNotEmpty(dto.getTitle())){
            update.set(notice.title , dto.getTitle());
        }

        if(isNotEmpty(dto.getContent())){
            update.set(notice.content , dto.getContent());
        }

        update.where(notice.seq.eq(seq));

        update.execute();

    }

    @Override
    public Page<Notice> findByAll(PageableDto dto) {

        JPAQuery<Notice> query = (JPAQuery<Notice>) jpaQueryFactory.from(notice);

        PageRequest pageable = PageRequest.of(dto.getPage() , dto.getSize());

        query.offset(pageable.getOffset()).limit(pageable.getPageSize());

        QueryResults<Notice> fetchResults = query.fetchResults();

        long total = fetchResults.getTotal();

        List<Notice> result = fetchResults.getResults();

        return new PageImpl<>(result, pageable, total);

    }


}
