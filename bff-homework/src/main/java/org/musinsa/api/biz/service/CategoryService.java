package org.musinsa.api.biz.service;

import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category get(Long categoryAutoSn) {
        return categoryRepository.findById(categoryAutoSn).orElseThrow(() -> new IllegalArgumentException("category not found"));
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
