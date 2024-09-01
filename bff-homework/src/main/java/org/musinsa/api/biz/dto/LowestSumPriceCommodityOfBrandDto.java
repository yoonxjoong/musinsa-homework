package org.musinsa.api.biz.dto;


import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.entity.Brand;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LowestSumPriceCommodityOfBrandDto {

    /**
     * 최저가 브랜드 상품 객체 리스트
     */
    private List<CommodityDto> commodities;

    /**
     * 브랜드명
     */
    private String brandNm;

    /**
     * 총액
     */
    private BigDecimal sumPrice;

    @Builder
    public LowestSumPriceCommodityOfBrandDto(List<CommodityDto> commodities, String brandNm) {
        this.commodities = commodities;
        this.sumPrice = commodities.stream()
                .map(CommodityDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.brandNm = brandNm;
    }

    public static LowestSumPriceCommodityOfBrandDto of(List<CommodityDto> commodities, Brand brand) {
        return LowestSumPriceCommodityOfBrandDto.builder()
                .commodities(commodities)
                .brandNm(brand.getName())
                .build();
    }

}
