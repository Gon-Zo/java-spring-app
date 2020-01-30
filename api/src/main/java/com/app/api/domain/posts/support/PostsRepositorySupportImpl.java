package com.app.api.domain.posts.support;

import com.app.api.domain.posts.Posts;
import com.app.api.web.dto.PostsResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.app.api.domain.posts.QPosts.posts;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class PostsRepositorySupportImpl extends QuerydslRepositorySupport implements PostsRepositorySupport {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public PostsRepositorySupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Posts.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /**
     * update to posts
     *
     * @param id  - long
     * @param dto - PostsResponseDto
     * @return long
     */
    @Override
    @Transactional
    public long update(Long id, PostsResponseDto dto) {
        JPAUpdateClause obj = jpaQueryFactory.update(posts);
        supportUpdate(obj, dto).where(posts.id.eq(id)).execute();
        return id;
    }

    /**
     * support to update query
     *
     * @param update
     * @param dto
     * @return JPAUpdateClause
     */
    private JPAUpdateClause supportUpdate(JPAUpdateClause update, PostsResponseDto dto) {
        if (!isEmpty(dto.getTitle())) {
            update.set(posts.title, dto.getTitle());
        }
        if (!isEmpty(dto.getContent())) {
            update.set(posts.content, dto.getContent());
        }
        if (!isEmpty(dto.getAuthor())) {
            update.set(posts.author, dto.getAuthor());
        }
        return update;
    }

}
