package org.musinsa.api.biz.data;

import lombok.Getter;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class SampleData {
    private final Map<Brand, Map<Category, BigDecimal>> initCommodity;

    private final List<String> intlCategories;

    private final List<String> intlBrands;

    public SampleData() {
        /**
         * 카테고리 리스트
         */
        this.intlCategories = List.of("상의", "아우터", "바지", "스니커즈", "가방", "모자", "양말", "액세서리");

        /**
         * 브랜드 리스트
         */
        this.intlBrands = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");

        // 카테고리 맵 생성 - A 브랜드
        Map<Category, BigDecimal> aCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(11200),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(5500),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(4200),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9000),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2000),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1700),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(1800),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2300)
        );

        // 카테고리 맵 생성 - B 브랜드
        Map<Category, BigDecimal> bCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10500),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(5900),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3800),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9100),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2100),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(2000),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2000),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2200)
        );

        // 카테고리 맵 생성 - C 브랜드
        Map<Category, BigDecimal> cCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10000),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(6200),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3300),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9200),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2200),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1900),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2200),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2100)
        );

        // 카테고리 맵 생성 - D 브랜드
        Map<Category, BigDecimal> dCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10100),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(5100),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3000),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9500),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2500),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1500),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2400),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2000)
        );

        // 카테고리 맵 생성 - E 브랜드
        Map<Category, BigDecimal> eCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10700),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(5000),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3800),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9900),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2300),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1800),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2100),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2100)
        );

        // 카테고리 맵 생성 - F 브랜드
        Map<Category, BigDecimal> fCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(11200),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(7200),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(4000),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9300),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2100),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1600),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2300),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(1900)
        );

        // 카테고리 맵 생성 - G 브랜드
        Map<Category, BigDecimal> gCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10500),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(5800),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3900),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9000),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2200),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1700),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2100),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2000)
        );

        // 카테고리 맵 생성 - H 브랜드
        Map<Category, BigDecimal> hCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(10800),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(6300),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3100),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9700),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2100),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1600),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(2000),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2000)
        );

        // 카테고리 맵 생성 - I 브랜드
        Map<Category, BigDecimal> iCategory = Map.of(
                Category.of(intlCategories.get(0)), BigDecimal.valueOf(11400),
                Category.of(intlCategories.get(1)), BigDecimal.valueOf(6700),
                Category.of(intlCategories.get(2)), BigDecimal.valueOf(3200),
                Category.of(intlCategories.get(3)), BigDecimal.valueOf(9500),
                Category.of(intlCategories.get(4)), BigDecimal.valueOf(2400),
                Category.of(intlCategories.get(5)), BigDecimal.valueOf(1700),
                Category.of(intlCategories.get(6)), BigDecimal.valueOf(1700),
                Category.of(intlCategories.get(7)), BigDecimal.valueOf(2400)
        );

        initCommodity = Map.of(
                Brand.of(intlBrands.get(0)), aCategory,
                Brand.of(intlBrands.get(1)), bCategory,
                Brand.of(intlBrands.get(2)), cCategory,
                Brand.of(intlBrands.get(3)), dCategory,
                Brand.of(intlBrands.get(4)), eCategory,
                Brand.of(intlBrands.get(5)), fCategory,
                Brand.of(intlBrands.get(6)), gCategory,
                Brand.of(intlBrands.get(7)), hCategory,
                Brand.of(intlBrands.get(8)), iCategory
        );
    }

}
