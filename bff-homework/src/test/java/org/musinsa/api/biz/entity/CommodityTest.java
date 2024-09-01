package org.musinsa.api.biz.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.musinsa.api.biz.Const;
import org.musinsa.api.biz.common.BaseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommodityTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateCommodity() {
        String categoryName = "상의";
        String brandName = "B";
        BigDecimal price = BigDecimal.valueOf(10000);

        Category category = Category.of(categoryName);
        Brand brand = Brand.of(brandName);
        Commodity commodity = Commodity.of(brand, category, price);

        assertEquals(BaseEntity.UseYn.Y, commodity.getUseYn());
        assertEquals(brandName, commodity.getBrand().getName());
        assertEquals(categoryName, commodity.getCategory().getName());
        assertEquals(price, commodity.getPrice());
        assertEquals(Const.SYSTEM, commodity.getRegId());
        assertEquals(Const.SYSTEM, commodity.getModifyId());
    }

    @Test
    public void testUpdateCommodity() {
        String sourceCategoryName = "상의";
        String sourceBrandName = "B";
        BigDecimal sourcePrice = BigDecimal.valueOf(10000);

        Category sourceCategory = Category.of(sourceCategoryName);
        Brand sourceBrand = Brand.of(sourceBrandName);
        Commodity sourceCommodity = Commodity.of(sourceBrand, sourceCategory, sourcePrice);

        String targetCategoryNm = "바지";
        String targetBrandNm = "A";
        BigDecimal targetPrice = BigDecimal.valueOf(9000);

        Category targetCategory = Category.of(targetCategoryNm);
        Brand targetBrand = Brand.of(targetBrandNm);
        Commodity targetCommodity = Commodity.of(targetBrand, targetCategory, targetPrice);

        sourceCommodity.update(targetCommodity);

        assertEquals(sourceCommodity.getCategory().getName(), targetCommodity.getCategory().getName());
        assertEquals(sourceCommodity.getBrand().getName(), targetCommodity.getBrand().getName());
        assertEquals(sourceCommodity.getPrice(), targetCommodity.getPrice());
    }
}
