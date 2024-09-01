package org.musinsa.api.biz.repository.customs;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.musinsa.api.biz.common.BaseEntity;
import org.musinsa.api.biz.entity.*;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class CommodityRepositoryCustomsImpl implements CommodityRepositoryCustoms {

    private final JPAQueryFactory queryFactory;

    private final QCommodity commodity = QCommodity.commodity;
    private final QBrand brand = QBrand.brand;
    private final QCategory category = QCategory.category;

    public CommodityRepositoryCustomsImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public List<Commodity> findMinPriceCommodities() {
        QCommodity subCommodity = new QCommodity("subCommodity");

        // 카테고리별 최저 금액 리스트 조회
        List<Commodity> commodities = queryFactory
                .selectFrom(commodity)
                .leftJoin(commodity.brand, brand).fetchJoin()
                .leftJoin(commodity.category, category).fetchJoin()
                .where(
                        commodity.price.eq(
                                JPAExpressions
                                        .select(subCommodity.price.min())
                                        .from(subCommodity)
                                        .where(subCommodity.category.categoryAutoSn.eq(commodity.category.categoryAutoSn))
                        )
                )
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .orderBy(brand.sortSeqNo.desc())
                .fetch();

        Map<Long, List<Commodity>> groupedByCategory = commodities.stream()
                .collect(Collectors.groupingBy(c -> c.getCategory().getCategoryAutoSn()));

        return groupedByCategory.values().stream()
                .map(list -> list.stream()
                        .max(Comparator.comparingLong(c -> c.getBrand().getBrandAutoSn()))
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<Commodity> findCommoditiesOfBrand(Long brandAutoSn) {
        return queryFactory
                .select(commodity)
                .from(commodity)
                .leftJoin(commodity.brand, brand).fetchJoin()
                .leftJoin(commodity.category, category).fetchJoin()
                .where(commodity.brand.brandAutoSn.eq(brandAutoSn))
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .orderBy(category.sortSeqNo.asc())
                .fetch();
    }

    @Override
    public Brand findMinSumPriceBrand() {
        // 브랜드 별 총 금액 조회
        Tuple minTotalPriceTuple = queryFactory
                .select(commodity.brand.brandAutoSn, commodity.price.sum())
                .from(commodity)
                .groupBy(commodity.brand.brandAutoSn)
                .orderBy(commodity.price.sum().asc())
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .fetchFirst();

        Long minBrandAutoSn = minTotalPriceTuple.get(commodity.brand.brandAutoSn);

        return queryFactory
                .select(brand)
                .from(brand)
                .where(brand.brandAutoSn.eq(minBrandAutoSn))
                .fetchOne();
    }

    @Override
    public Commodity findLowestPriceCommodity(Category category) {
        return queryFactory
                .select(commodity)
                .from(commodity)
                .leftJoin(commodity.brand, brand).fetchJoin()
                .leftJoin(commodity.category).fetchJoin()
                .where(commodity.category.categoryAutoSn.eq(category.getCategoryAutoSn()))
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .orderBy(commodity.price.asc())
                .fetchFirst();
    }

    @Override
    public Commodity findHighestPriceCommodity(Category category) {
        return queryFactory
                .select(commodity)
                .from(commodity)
                .leftJoin(commodity.brand, brand).fetchJoin()
                .leftJoin(commodity.category).fetchJoin()
                .where(commodity.category.categoryAutoSn.eq(category.getCategoryAutoSn()))
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .orderBy(commodity.price.desc())
                .fetchFirst();
    }

    @Override
    public Commodity findSameCommodity(Commodity targetCommodity) {
        return queryFactory
                .select(commodity)
                .from(commodity)
                .leftJoin(commodity.brand, brand).fetchJoin()
                .leftJoin(commodity.category).fetchJoin()
                .where(commodity.brand.brandAutoSn.eq(targetCommodity.getBrand().getBrandAutoSn()))
                .where(commodity.category.categoryAutoSn.eq(targetCommodity.getCategory().getCategoryAutoSn()))
                .where(commodity.useYn.eq(BaseEntity.UseYn.valueOf("Y")))
                .fetchFirst();
    }
}
