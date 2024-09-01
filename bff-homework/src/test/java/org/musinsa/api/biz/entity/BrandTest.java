package org.musinsa.api.biz.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.musinsa.api.biz.Const;
import org.musinsa.api.biz.common.BaseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BrandTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBrandWithName() {
        String name = "Test Brand";

        Brand brand = Brand.of(name);

        assertNotNull(brand);
        assertEquals(name, brand.getName());
        assertEquals(BaseEntity.UseYn.Y, brand.getUseYn());
        assertEquals(Const.SYSTEM, brand.getRegId());
        assertEquals(Const.SYSTEM, brand.getModifyId());
        assertNull(brand.getSortSeqNo());
    }

    @Test
    public void testCreateBrandWithNameAndSortSeqNo() {
        String name = "상의";
        Long sortSeqNo = 1L;

        Brand brand = Brand.of(name, sortSeqNo);

        assertNotNull(brand);
        assertEquals(name, brand.getName());
        assertEquals(sortSeqNo, brand.getSortSeqNo());
        assertEquals(BaseEntity.UseYn.Y, brand.getUseYn());
        assertEquals(Const.SYSTEM, brand.getRegId());
        assertEquals(Const.SYSTEM, brand.getModifyId());
    }
}
