package org.musinsa.api.biz.service;

import org.musinsa.api.biz.dto.CommodityDto;
import org.musinsa.api.biz.dto.LowestAndHighestPriceBrandDto;
import org.musinsa.api.biz.dto.LowestPriceCommodityOfCategoryDto;
import org.musinsa.api.biz.dto.LowestSumPriceCommodityOfBrandDto;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.repository.CategoryRepository;
import org.musinsa.api.biz.repository.CommodityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommodityService {

    private final CommodityRepository commodityRepository;

    private final CategoryRepository categoryRepository;

    public CommodityService(CommodityRepository commodityRepository, CategoryRepository categoryRepository) {
        this.commodityRepository = commodityRepository;
        this.categoryRepository = categoryRepository;
    }

    public LowestPriceCommodityOfCategoryDto searchLowestPriceCommodityByCategory() {

        List<Commodity> commodities = commodityRepository.findMinPriceCommodities();

        return LowestPriceCommodityOfCategoryDto.of(
                commodities.stream().map(Commodity::toDto).collect(Collectors.toList())
        );
    }

    public LowestSumPriceCommodityOfBrandDto searchLowestSumPriceCommodityByBrand() {

        Brand brand = commodityRepository.findMinSumPriceBrand();

        List<Commodity> commodities = commodityRepository.findCommoditiesOfBrand(brand.getBrandAutoSn());

        return LowestSumPriceCommodityOfBrandDto.of(
                commodities.stream().map(Commodity::toCategoryDto).collect(Collectors.toList()),
                brand
        );
    }

    public LowestAndHighestPriceBrandDto searchLowestAndHighestPriceBrand(String categoryName) {
        Optional<Category> category = categoryRepository.findByName(categoryName);

        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }

        Commodity minCommodity = commodityRepository.findLowestPriceCommodity(category.get());

        Commodity maxCommodity = commodityRepository.findHighestPriceCommodity(category.get());

        return LowestAndHighestPriceBrandDto.of(
                category.get().getName(),
                minCommodity.toBrandDto(),
                maxCommodity.toBrandDto()
        );
    }

    public void save(Commodity commodity) {
        Commodity sourceCommodity = commodityRepository.findSameCommodity(commodity);

        if(sourceCommodity != null) {
            throw new IllegalArgumentException("Commodity already exists");
        }

        commodityRepository.save(commodity);
    }

    public void update(Commodity targetCommodity) {
        commodityRepository.save(targetCommodity);

    }

    public void delete(UUID uuid) {
        commodityRepository.deleteById(uuid);
    }



    public Commodity get(UUID uuid) {
        return commodityRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Commodity not found"));
    }

    public List<CommodityDto> getAll() {
        return commodityRepository.findAll().stream().map(Commodity::toDto).collect(Collectors.toList());
    }
}
