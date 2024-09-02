package org.musinsa.api.biz.service;

import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand get(Long brandAutoSn) {
        return brandRepository.findById(brandAutoSn).orElseThrow(() -> new IllegalArgumentException("brand not found"));
    }

    public void save(Brand brand) {
        Brand existingBrand = brandRepository.findByName(brand.getName()).orElse(null);

        if (existingBrand!= null) {
            throw new IllegalArgumentException("brand already exists");
        }
        brandRepository.save(brand);
    }

    public void delete(Long brandAutoSn) {
        brandRepository.deleteById(brandAutoSn);
    }

    public void update(Brand brand) {
        brandRepository.save(brand);
    }

}
