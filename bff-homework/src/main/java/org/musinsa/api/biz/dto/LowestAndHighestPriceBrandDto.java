package org.musinsa.api.biz.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LowestAndHighestPriceBrandDto {
    /**
     * 카테고리명
     */
    private String categoryNm;

    /**
     * 최저 가격 브랜드, 상품 객체
     */
    private CommodityDto lowestPriceCommodity;

    /**
     * 최고 가격 브랜드, 상품 객체
     */
    private CommodityDto highestPriceCommodity;

    @Builder
    public LowestAndHighestPriceBrandDto(String categoryNm, CommodityDto lowestPriceCommodity, CommodityDto highestPriceCommodity) {
        this.categoryNm = categoryNm;
        this.lowestPriceCommodity = lowestPriceCommodity;
        this.highestPriceCommodity = highestPriceCommodity;
    }

    public static LowestAndHighestPriceBrandDto of(String categoryNm, CommodityDto lowestPriceCommodity, CommodityDto highestPriceCommodity) {
        return LowestAndHighestPriceBrandDto.builder()
                .categoryNm(categoryNm)
                .lowestPriceCommodity(lowestPriceCommodity)
                .highestPriceCommodity(highestPriceCommodity)
                .build();
    }
}
