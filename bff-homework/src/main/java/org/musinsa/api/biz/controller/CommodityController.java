package org.musinsa.api.biz.controller;

import org.musinsa.api.biz.common.BaseResponse;
import org.musinsa.api.biz.dto.CommodityDto;
import org.musinsa.api.biz.dto.LowestAndHighestPriceBrandDto;
import org.musinsa.api.biz.dto.LowestPriceCommodityOfCategoryDto;
import org.musinsa.api.biz.dto.LowestSumPriceCommodityOfBrandDto;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.request.CommoditySaveRequest;
import org.musinsa.api.biz.service.BrandService;
import org.musinsa.api.biz.service.CategoryService;
import org.musinsa.api.biz.service.CommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/commodity")
public class CommodityController {

    private final CommodityService commodityService;

    private final BrandService brandService;

    private final CategoryService categoryService;

    public CommodityController(CommodityService commodityService, BrandService brandService, CategoryService categoryService) {
        this.commodityService = commodityService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    /**
     * 카테고리 별 최저 가격 브랜드와 상품 가격, 총액을 조회하는 API
     * @return
     */
    @GetMapping("/lowest-price-by-category")
    public ResponseEntity<BaseResponse<LowestPriceCommodityOfCategoryDto>> searchLowestPriceCommodityByCategory() {
        LowestPriceCommodityOfCategoryDto response = commodityService.searchLowestPriceCommodityByCategory();

        return ResponseEntity.ok(new BaseResponse<>(response, "Success", HttpStatus.OK.value()));
    }

    /**
     * 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
     * @return
     */
    @GetMapping("/lowest-sum-price-by-brand")
    public ResponseEntity<BaseResponse<LowestSumPriceCommodityOfBrandDto>> searchLowestSumPriceCommodityByBrand() {
        LowestSumPriceCommodityOfBrandDto response = commodityService.searchLowestSumPriceCommodityByBrand();

        return ResponseEntity.ok(new BaseResponse<>(response, "Success", HttpStatus.OK.value()));
    }

    /**
     * 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
     * @param categoryName 카테고리명
     * @return
     */
    @GetMapping("/lowest-and-highest-price-by-brand/{categoryName}")
    public ResponseEntity<BaseResponse<LowestAndHighestPriceBrandDto>> searchLowestAndHighestPriceBrand(
            @PathVariable String categoryName) {
        LowestAndHighestPriceBrandDto response = commodityService.searchLowestAndHighestPriceBrand(categoryName);

        return ResponseEntity.ok(new BaseResponse<>(response, "Success", HttpStatus.OK.value()));
    }

    /**
     * 모든 상품 조회하는 API
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<CommodityDto>>> getAllCommodities() {
        List<CommodityDto> commodities = commodityService.getAll();

        BaseResponse<List<CommodityDto>> response = new BaseResponse<>(
                commodities,
                "Success",
                HttpStatus.OK.value()
        );

        return ResponseEntity.ok(response);
    }

    /**
     * 상품 저장
     * @param request 상품 정보
     * @return
     */
    // save
    @PostMapping("/")
    public ResponseEntity<BaseResponse<String>> save(@RequestBody @Validated CommoditySaveRequest request) {
        // 브랜드 검색
        Brand brand = brandService.get(request.getBrandAutoSn());

        if (brand == null) {
            return new ResponseEntity<>(new BaseResponse<>("Brand not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        // 카테고리 검색
        Category category = categoryService.get(request.getCategoryAutoSn());

        if (category == null) {
            return new ResponseEntity<>(new BaseResponse<>("Category not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        commodityService.save(request.toCommodity(brand, category));

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * 상품 수정
     * @param commodityAutoSn 상품 번호
     * @param request 상품 정보
     * @return
     */
    @PutMapping("/{commodityAutoSn}")
    public ResponseEntity<BaseResponse<String>> updateCommodity(@PathVariable UUID commodityAutoSn, @RequestBody @Validated CommoditySaveRequest request) {
        Commodity commodity = commodityService.get(commodityAutoSn);
        if (commodity == null) {
            return new ResponseEntity<>(new BaseResponse<>("Commodity not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        Brand brand = brandService.get(request.getBrandAutoSn());
        if (brand == null) {
            return new ResponseEntity<>(new BaseResponse<>("Brand not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        Category category = categoryService.get(request.getCategoryAutoSn());
        if (category == null) {
            return new ResponseEntity<>(new BaseResponse<>("Category not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        commodity.update(request.toCommodity(brand, category));
        commodityService.update(commodity);

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 상품 삭제
     * @param commodityAutoSn 상품 번호
     * @return
     */
    @DeleteMapping("/{commodityAutoSn}")
    public ResponseEntity<BaseResponse<String>> deleteCommodity(@PathVariable UUID commodityAutoSn) {
        Commodity commodity = commodityService.get(commodityAutoSn);

        if (commodity == null) {
            return new ResponseEntity<>(new BaseResponse<>("Commodity not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        commodityService.delete(commodityAutoSn);

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
