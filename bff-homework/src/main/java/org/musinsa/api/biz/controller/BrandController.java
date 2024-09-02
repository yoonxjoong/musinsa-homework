package org.musinsa.api.biz.controller;


import org.musinsa.api.biz.common.BaseResponse;
import org.musinsa.api.biz.dto.BrandDto;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.request.BrandSaveRequest;
import org.musinsa.api.biz.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<BrandDto>>> getAllBrands() {
        List<Brand> brands = brandService.getAll();

        List<BrandDto> brandDtoList = brands.stream()
                .map(BrandDto::of)
                .toList();

        BaseResponse<List<BrandDto>> response = new BaseResponse<>(
                brandDtoList,
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BaseResponse<String>> saveBrand(@RequestBody BrandSaveRequest request) {

        brandService.save(request.toBrand());

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{brandAutoSn}")
    public ResponseEntity<BaseResponse<String>> updateBrand(@PathVariable Long brandAutoSn, @RequestBody BrandSaveRequest request) {
        Brand brand = brandService.get(brandAutoSn);
        if (brand == null) {
            return new ResponseEntity<>(new BaseResponse<>("Brand not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        brand.update(request.toBrand());
        brandService.update(brand);

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{brandAutoSn}")
    public ResponseEntity<BaseResponse<String>> deleteBrand(@PathVariable Long brandAutoSn) {
        Brand brand = brandService.get(brandAutoSn);
        if (brand == null) {
            return new ResponseEntity<>(new BaseResponse<>("Brand not found", HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
        }

        brandService.delete(brandAutoSn);

        BaseResponse<String> response = new BaseResponse<>(
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
