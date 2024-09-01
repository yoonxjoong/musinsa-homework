package org.musinsa.api.biz.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LowestPriceCommodityOfCategoryDto {

    /**
     * 최저 가격 브랜드 상품 객체 리스트
     */
    private List<CommodityDto> commodities;

    /**
     * 총액
     */
    private BigDecimal sumPrice;

    @Builder
    public LowestPriceCommodityOfCategoryDto(List<CommodityDto> commodities) {
        this.commodities = commodities;
        this.sumPrice = commodities.stream()
                .map(CommodityDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static LowestPriceCommodityOfCategoryDto of(List<CommodityDto> commodities) {
        return LowestPriceCommodityOfCategoryDto.builder()
                .commodities(commodities)
                .build();
    }
}
