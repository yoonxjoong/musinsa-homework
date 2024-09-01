package org.musinsa.api.biz.repository.customs;

import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;

import java.util.List;

public interface CommodityRepositoryCustoms {
    /**
     * 카테고리별 최저 가격 브랜드와 상품 조회
     *
     * @return
     */
    List<Commodity> findMinPriceCommodities();

    /**
     * 모든 카테고리 상품의 최저 가격인 브랜드 조회
     *
     * @return
     */
    Brand findMinSumPriceBrand();

    /**
     * 브랜드의 상품정보 조회
     *
     * @param brandAutoSn 브랜드 번호
     * @return
     */
    List<Commodity> findCommoditiesOfBrand(Long brandAutoSn);

    /**
     * 최저 가격인 상품 조회
     * @param category 카테고리 객체
     * @return 최저 가격 상품 객체
     */
    Commodity findLowestPriceCommodity(Category category);

    /**
     * 최고 가격인 상품 조회
     * @param category 카테고리 객체
     * @return 최고 가격 상품 객체
     */
    Commodity findHighestPriceCommodity(Category category);

    /**
     * 동일한 상품 정보 조회
     * @param commodity 대상 상품 객체
     * @return 타겟 상품 객체
     */
    Commodity findSameCommodity(Commodity commodity);
}
