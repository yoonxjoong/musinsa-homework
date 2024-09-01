package org.musinsa.api.biz.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.musinsa.api.biz.dto.CommodityDto;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.repository.CategoryRepository;
import org.musinsa.api.biz.dto.LowestAndHighestPriceBrandDto;
import org.musinsa.api.biz.dto.LowestPriceCommodityOfCategoryDto;
import org.musinsa.api.biz.dto.LowestSumPriceCommodityOfBrandDto;
import org.musinsa.api.biz.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CommodityServiceTest {



    @Autowired
    private CommodityService commodityService;


    @Test
    @DisplayName("단일 브랜드로 모든 상품을 구매할 경우 최저가 정보 일치 테스트")
    void searchLowestPriceSumCommodityByBrand() {
        LowestSumPriceCommodityOfBrandDto obj = commodityService.searchLowestSumPriceCommodityByBrand();

        // 1. CommodityDto 객체 생성
        CommodityDto commodity1 = CommodityDto.ofCategory(Commodity.of(Category.of("상의"), BigDecimal.valueOf(10100)));
        CommodityDto commodity2 = CommodityDto.ofCategory(Commodity.of(Category.of("아우터"), BigDecimal.valueOf(5100)));
        CommodityDto commodity3 = CommodityDto.ofCategory(Commodity.of(Category.of("바지"), BigDecimal.valueOf(3000)));
        CommodityDto commodity4 = CommodityDto.ofCategory(Commodity.of(Category.of("스니커즈"), BigDecimal.valueOf(9500)));
        CommodityDto commodity5 = CommodityDto.ofCategory(Commodity.of(Category.of("가방"), BigDecimal.valueOf(2500)));
        CommodityDto commodity6 = CommodityDto.ofCategory(Commodity.of(Category.of("모자"), BigDecimal.valueOf(1500)));
        CommodityDto commodity7 = CommodityDto.ofCategory(Commodity.of(Category.of("양말"), BigDecimal.valueOf(2400)));
        CommodityDto commodity8 = CommodityDto.ofCategory(Commodity.of(Category.of("액세서리"), BigDecimal.valueOf(2000)));

        List<CommodityDto> sampleCommodities = Arrays.asList(commodity1, commodity2, commodity3, commodity4, commodity5, commodity6, commodity7, commodity8);

        assertEquals(obj.getBrandNm(), "D");
        assertEquals(obj.getCommodities().size(), 8);
        assertEquals(obj.getSumPrice(), new BigDecimal(36100));

        assertThat(obj.getCommodities()).isEqualTo(sampleCommodities);

    }

    @Test
    @DisplayName("카테고리 별 최저, 최고 가격 브랜드와 상품 조회 테스트")
    void searchLowestAndHighestPriceBrand() {
        LowestAndHighestPriceBrandDto obj = commodityService.searchLowestAndHighestPriceBrand("상의");

        assertEquals(obj.getCategoryNm(), "상의");
        assertEquals(obj.getLowestPriceCommodity().getBrandNm(), "C");
        assertEquals(obj.getLowestPriceCommodity().getPrice(), BigDecimal.valueOf(10000));

        assertEquals(obj.getHighestPriceCommodity().getBrandNm(), "I");
        assertEquals(obj.getHighestPriceCommodity().getPrice(), BigDecimal.valueOf(11400));
    }



    @Test
    public void searchLowestAndHighestPriceBrand_ValidCategory_ReturnsCorrectBrands() {
        String categoryName = "상의";
        Category category = Category.of(categoryName, 1L);

        Brand minBrand = Brand.of("C", 3L);
        Commodity minCommodity = Commodity.of(minBrand, category, new BigDecimal("10000"));

        Brand maxBrand = Brand.of("I", 9L);
        Commodity maxCommodity = Commodity.of(minBrand, category, new BigDecimal("11400"));

        LowestAndHighestPriceBrandDto response = commodityService.searchLowestAndHighestPriceBrand(categoryName);

        assertEquals(categoryName, response.getCategoryNm());
        assertEquals(minBrand.getName(), response.getLowestPriceCommodity().getBrandNm());
        assertEquals(maxBrand.getName(), response.getHighestPriceCommodity().getBrandNm());
        assertEquals(minCommodity.getPrice(), response.getLowestPriceCommodity().getPrice());
        assertEquals(maxCommodity.getPrice(), response.getHighestPriceCommodity().getPrice());
    }
}
