package org.musinsa.api.biz.data;

import jakarta.annotation.PostConstruct;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.repository.BrandRepository;
import org.musinsa.api.biz.repository.CategoryRepository;
import org.musinsa.api.biz.repository.CommodityRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DataInitializer {
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final CommodityRepository commodityRepository;
    private final SampleData sampleData;



    public DataInitializer(BrandRepository brandRepository, CategoryRepository categoryRepository, SampleData sampleData, CommodityRepository commodityRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.commodityRepository = commodityRepository;
        this.sampleData = sampleData;
    }

    @PostConstruct
    public void  initializeData(){
        // 1. 브랜드 저장
        Map<String, Brand> brands = IntStream.range(0, sampleData.getIntlBrands().size())
                .mapToObj(i -> {
                    String name = sampleData.getIntlBrands().get(i);
                    Long index = (long) i;
                    return Brand.of(name, index);
                })
                .map(brandRepository::save)
                .collect(Collectors.toMap(Brand::getName, brand -> brand));

        // 2. 카테고리 저장
        Map<String, Category> categories = IntStream.range(0, sampleData.getIntlCategories().size())
                .mapToObj(i -> {
                    String name = sampleData.getIntlCategories().get(i);
                    Long index = (long) i;
                    return Category.of(name, index);
                })
                .map(categoryRepository::save)
                .collect(Collectors.toMap(Category::getName, category -> category));

        // 3. 상품 저장
        sampleData.getInitCommodity().forEach((brandName, categoryPrices) -> {
            Brand brand = brands.get(brandName.getName());

            categoryPrices.forEach((categoryName, price) -> {
                Category category = categories.get(categoryName.getName());
                Commodity commodity = Commodity.of(brand, category, price);
                commodityRepository.save(commodity);
            });
        });
    }
}
