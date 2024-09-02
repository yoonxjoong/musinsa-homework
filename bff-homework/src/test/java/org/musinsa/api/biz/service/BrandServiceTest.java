package org.musinsa.api.biz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.musinsa.api.biz.dto.CommodityDto;
import org.musinsa.api.biz.dto.LowestAndHighestPriceBrandDto;
import org.musinsa.api.biz.dto.LowestSumPriceCommodityOfBrandDto;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;
import org.musinsa.api.biz.entity.Commodity;
import org.musinsa.api.biz.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BrandServiceTest {

//    @Autowired
//    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    private Brand brand;

    @BeforeEach
    void setUp() {
        brand = Brand.of("Test Brand");
    }


    @Test
    void testGetAll() {
        List<Brand> brands = new ArrayList<>();
        brands.add(brand);

        when(brandRepository.findAll()).thenReturn(brands);

        List<Brand> result = brandService.getAll();
        assertEquals(1, result.size());
        assertEquals("Test Brand", result.get(0).getName());
    }

    @Test
    void testGet() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));

        Brand result = brandService.get(1L);
        assertNotNull(result);
        assertEquals("Test Brand", result.getName());
    }

    @Test
    void testGetNotFound() {
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            brandService.get(1L);
        });
        assertEquals("brand not found", exception.getMessage());
    }

    @Test
    void testSave() {
        brandService.save(brand);
        verify(brandRepository, times(1)).save(brand);
    }

    @Test
    void testDelete() {
        brandService.delete(1L);
        verify(brandRepository, times(1)).deleteById(1L);
    }
}
