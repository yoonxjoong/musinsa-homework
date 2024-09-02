package org.musinsa.api.biz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.entity.Commodity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CommodityDto {
    private UUID commodityNo;

    /**
     * 브랜드명
     */
    private String brandNm;

    /**
     * 브랜드 번호
     */
    private Long brandAutoSn;

    /**
     * 카테고리명
     */
    private String categoryNm;

    /**
     * 카테고리번호
     */
    private Long categoryAutoSn;

    /**
     * 금액
     */
    private BigDecimal price;

    @Builder
    public CommodityDto(UUID commodityNo, String brandNm, Long brandAutoSn, String categoryNm, Long categoryAutoSn, BigDecimal price) {
        this.commodityNo = commodityNo;
        this.brandNm = brandNm;
        this.brandAutoSn = brandAutoSn;
        this.categoryNm = categoryNm;
        this.categoryAutoSn = categoryAutoSn;
        this.price = price;
    }

    public static CommodityDto of(Commodity commodity) {
        return CommodityDto.builder()
                .commodityNo(commodity.getCommodityNo())
                .brandNm(commodity.getBrand().getName())
                .brandAutoSn(commodity.getBrand().getBrandAutoSn())
                .categoryNm(commodity.getCategory().getName())
                .categoryAutoSn(commodity.getCategory().getCategoryAutoSn())
                .price(commodity.getPrice()).build();
    }

    public static CommodityDto ofCategory(Commodity commodity) {
        return CommodityDto.builder()
                .categoryAutoSn(commodity.getCategory().getCategoryAutoSn())
                .categoryNm(commodity.getCategory().getName())
                .price(commodity.getPrice())
                .build();
    }

    public static CommodityDto ofBrand(Commodity commodity) {
        return CommodityDto.builder()
                .brandAutoSn(commodity.getBrand().getBrandAutoSn())
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
