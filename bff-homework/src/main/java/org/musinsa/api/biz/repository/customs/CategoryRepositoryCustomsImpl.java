package org.musinsa.api.biz.repository.customs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.QCategory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepositoryCustomsImpl implements CategoryRepositoryCustoms {

    private final JPAQueryFactory queryFactory;

    private final QCategory category = QCategory.category;

    public CategoryRepositoryCustomsImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public Optional<Category> findByName(String name) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(category)
                        .where(category.name.eq(name))
                        .fetchOne()
        );
    }
}
