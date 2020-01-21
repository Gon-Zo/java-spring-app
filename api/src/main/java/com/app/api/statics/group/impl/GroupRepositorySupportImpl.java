package com.app.api.statics.group.impl;

import com.app.api.statics.group.Group;
import com.app.api.statics.group.GroupDto;
import com.app.api.statics.group.GroupRepositorySupport;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Transient;

import static com.app.api.statics.group.QGroup.group;
import static com.app.api.statics.comm.XAppUtil.isNotEmpty;
import static com.app.api.statics.comm.XAppUtil.isNotInitialVal;

@Repository
public class GroupRepositorySupportImpl extends QuerydslRepositorySupport implements GroupRepositorySupport {


    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public GroupRepositorySupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Group.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }


    /**
     * find by one group
     * Query : Select * From Group where [ dynamic where query ]
     *
     * @param param - Group.Param.class
     * @return
     */
    @Override
    public Group findBy(GroupDto.Param param) {
        return jpaQueryFactory
                .selectFrom(group)
                .where(getBooleanBuilder(param))
                .fetchOne();
    }

    /**
     * @param param
     */
    @Override
    @Transient
    public void updateOf(GroupDto.Param param) {
        getUpdateCase(group, param).where(getBooleanBuilder(param)).execute();
    }

    /**
     * Dynamic Update Query
     *
     * @param entityPath
     * @param param
     * @return
     */
    private UpdateClause<JPAUpdateClause> getUpdateCase(EntityPath entityPath, GroupDto.Param param) {
        UpdateClause<JPAUpdateClause> uc = update(entityPath);
        if (isNotInitialVal(param.getSeq())) {
            uc.set(group.seq, param.getSeq());
        }
        if (isNotEmpty(param.getTitle())) {
            uc.set(group.title, param.getTitle());
        }
        if (isNotEmpty(param.getInfo())) {
            uc.set(group.info, param.getInfo());
        }
        return uc;
    }

    /**
     * Dynamic where Query
     *
     * @param param
     * @return
     */
    private BooleanBuilder getBooleanBuilder(GroupDto.Param param) {
        BooleanBuilder whereQuery = new BooleanBuilder();
        if (isNotInitialVal(param.getSeq())) {
            whereQuery.and(group.seq.eq(param.getSeq()));
        }
        if (isNotEmpty(param.getTitle())) {
            whereQuery.and(group.title.eq(param.getTitle()));
        }
        if (isNotEmpty(param.getInfo())) {
            whereQuery.and(group.info.eq(param.getInfo()));
        }
        return whereQuery;
    }

}
