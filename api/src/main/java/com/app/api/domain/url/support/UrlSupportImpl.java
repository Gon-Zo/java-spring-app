package com.app.api.domain.url.support;

import com.app.api.web.dto.UrlResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static com.app.api.domain.url.QUrl.url;

@Repository
public class UrlSupportImpl implements UrlSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public UrlSupportImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional
    public void update(long seq, UrlResponseDto dto) {
        jpaQueryFactory.update(url)
                .set(url.title , dto.getTitle())
                .where(url.seq.eq(seq))
                .execute();
    }

}
