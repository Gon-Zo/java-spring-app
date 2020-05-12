package com.app.api.domain.url.support;

import com.app.api.domain.url.Url;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlResponseDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.List;

import static com.app.api.domain.url.QUrl.url;
import static com.app.api.utils.ApiDomainUtils.isNotEmpty;
import static com.app.api.utils.ApiDomainUtils.getOrder;

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

    @Override
    public Page<Url> findByPage(PageableDto dto) {

        JPAQuery<Url> query = jpaQueryFactory.selectFrom(url);

        if(isNotEmpty(dto.getSort())){
            query.orderBy(getOrder(dto.getSort()).toArray(new OrderSpecifier[0]));
        }

        Pageable pageable = PageRequest.of(dto.getPage() , dto.getSize());

        query.offset(pageable.getOffset()).limit(pageable.getPageSize());

        QueryResults<Url> fetchResults = query.fetchResults();

        long total = fetchResults.getTotal();

        List<Url> results = fetchResults.getResults();

        return new PageImpl<>(results , pageable , total);

    }

}
