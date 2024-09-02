package org.musinsa.api.biz.controller;


import org.musinsa.api.biz.common.BaseResponse;
import org.musinsa.api.biz.dto.CategoryDto;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<CategoryDto>>> getAllBrands() {
        List<Category> categories = categoryService.getAll();

        List<CategoryDto> categoryDtoList = categories.stream()
                .map(CategoryDto::of)
                .toList();

        BaseResponse<List<CategoryDto>> response = new BaseResponse<>(
                categoryDtoList,
                "Success",
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
