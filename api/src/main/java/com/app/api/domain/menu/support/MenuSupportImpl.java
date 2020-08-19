package com.app.api.domain.menu.support;

import com.app.api.domain.menu.Menu;
import com.app.api.web.dto.MenuDto;
import com.app.api.web.dto.PageableDto;
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

import javax.transaction.Transactional;
import java.util.List;

import static com.app.api.domain.menu.QMenu.menu;
import static com.app.api.utils.ApiDomainUtils.isNotEmpty;
import static com.app.api.utils.ApiDomainUtils.getOrder;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Repository
public class MenuSupportImpl extends QuerydslRepositorySupport implements MenuSupport {

    private JPAQueryFactory jpaQueryFactory;

    public MenuSupportImpl(JPAQueryFactory jpaQueryFactory) {
        super(Menu.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Menu> findByPages(PageableDto dto) {

        JPAQuery<Menu> query = jpaQueryFactory.selectFrom(menu);

        if(isNotEmpty(dto.getSort())){
            query.orderBy(getOrder(dto.getSort()).toArray(new OrderSpecifier[0]));
        }

        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());

        query.limit(pageable.getPageSize()).offset(pageable.getOffset());

        QueryResults<Menu> fetchResults = query.fetchResults();

        long total = fetchResults.getTotal();

        List<Menu> results = fetchResults.getResults();

        return new PageImpl<>(results , pageable , total);
    }

    @Override
    @Transactional
    public void update(long seq, MenuDto dto) {
        UpdateClause<JPAUpdateClause> updateCase = update(menu);

        if (isNotEmpty(dto.getTitle())) {
            updateCase.set(menu.title, dto.getTitle());
        }
        if (isNotEmpty(dto.getUrl())) {
            updateCase.set(menu.url, dto.getUrl());
        }
        if (isNotEmpty(dto.getIcon())) {
            updateCase.set(menu.icon, dto.getIcon());
        }
        if (isNotEmpty(dto.getMenuOrder())) {
            updateCase.set(menu.menuOrder, dto.getMenuOrder());
        }

        updateCase.where(menu.seq.eq(seq));

        updateCase.execute();

    }


}
