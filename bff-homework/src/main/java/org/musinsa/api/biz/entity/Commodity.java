package org.musinsa.api.biz.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.musinsa.api.biz.Const;
import org.musinsa.api.biz.common.BaseEntity;
import org.musinsa.api.biz.dto.CommodityDto;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Commodity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID commodityNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_auto_sn")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_auto_sn")
    private Category category;

    @Column(precision = 16, scale = 0)
    private BigDecimal price;

    private String regId;

    private String modifyId;

    @Builder
    public Commodity(Brand brand, Category category, BigDecimal price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.useYn = UseYn.Y;
        this.regId = Const.SYSTEM;
        this.modifyId = Const.SYSTEM;
    }

    public static Commodity of(Brand brand, Category category, BigDecimal price) {
        return Commodity.builder().brand(brand).category(category).price(price).build();
    }

    public static Commodity of(Category category, BigDecimal price){
        return Commodity.builder().category(category).price(price).build();
    }

    public CommodityDto toDto() {
        return CommodityDto.of(this);
    }

    public CommodityDto toCategoryDto(){
        return CommodityDto.ofCategory(this);
    }

    public CommodityDto toBrandDto(){
        return CommodityDto.ofBrand(this);
    }

    /**
     * 상품 정보 변경
     * @param targetCommodity 변경할 상품
     */
    public void update(Commodity targetCommodity) {
        this.brand = targetCommodity.getBrand();
        this.category = targetCommodity.getCategory();
        this.useYn = targetCommodity.getUseYn();
        this.modifyId = Const.SYSTEM;

        if(targetCommodity.getPrice()!= null){
            this.price = targetCommodity.getPrice();
        }
    }
}
