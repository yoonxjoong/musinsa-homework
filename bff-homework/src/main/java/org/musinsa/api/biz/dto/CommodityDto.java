package org.musinsa.api.biz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.entity.Commodity;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CommodityDto {
    /**
     * 브랜드명
     */
    private String brandNm;

    /**
     * 카테고리명
     */
    private String categoryNm;

    /**
     * 금액
     */
    private BigDecimal price;

    @Builder
    public CommodityDto(String brandNm, String categoryNm, BigDecimal price) {
        this.brandNm = brandNm;
        this.categoryNm = categoryNm;
        this.price = price;
    }

    public static CommodityDto of(Commodity commodity) {
        return CommodityDto.builder()
                .brandNm(commodity.getBrand().getName())
                .categoryNm(commodity.getCategory().getName())
                .price(commodity.getPrice()).build();
    }

    public static CommodityDto ofCategory(Commodity commodity) {
        return CommodityDto.builder()
                .categoryNm(commodity.getCategory().getName())
                .price(commodity.getPrice())
                .build();
    }

    public static CommodityDto ofBrand(Commodity commodity) {
        return CommodityDto.builder()
               .brandNm(commodity.getBrand().getName())
               .price(commodity.getPrice())
               .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityDto that = (CommodityDto) o;
        return Objects.equals(brandNm, that.brandNm) &&
                Objects.equals(categoryNm, that.categoryNm) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandNm, categoryNm, price);
    }
}
