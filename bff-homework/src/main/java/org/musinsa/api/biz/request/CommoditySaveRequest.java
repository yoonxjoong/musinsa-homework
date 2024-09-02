package org.musinsa.api.biz.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.common.BaseEntity;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;

import java.math.BigDecimal;

@Data
@Builder
public class CommoditySaveRequest {

    @NotNull
    private Long brandAutoSn;

    @NotNull
    private Long categoryAutoSn;

    @NotNull
    private BigDecimal price;

    private BaseEntity.UseYn useYn;

    public Commodity toCommodity(Brand brand, Category category) {
        return Commodity.builder()
                .brand(brand)
                .category(category)
                .price(price)
                .build();
    }
}
