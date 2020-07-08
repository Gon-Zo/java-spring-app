package com.app.api.domain.notice.support;

import com.app.api.domain.notice.Notice;
import com.app.api.domain.notice.QNotice;
import com.app.api.web.dto.NoticeResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.app.api.domain.notice.QNotice.notice;

@Repository
public class NoticeSupportImpl extends QuerydslRepositorySupport implements NoticeSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public NoticeSupportImpl( JPAQueryFactory jpaQueryFactory) {
        super(Notice.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public void update(NoticeResponseDto dto, long seq) {
//        update(notice)
    }

}
