package org.musinsa.api.biz.repository.customs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.QBrand;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BrandRepositoryCustomsImpl implements BrandRepositoryCustoms {

    private final JPAQueryFactory queryFactory;

    private final QBrand brand = QBrand.brand;

    public BrandRepositoryCustomsImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public Optional<Brand> findByName(String name) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(brand)
                        .where(brand.name.eq(name))
                        .fetchOne()
        );
    }
}
