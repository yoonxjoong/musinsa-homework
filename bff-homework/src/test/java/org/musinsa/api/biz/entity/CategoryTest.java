package org.musinsa.api.biz.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.musinsa.api.biz.Const;
import org.musinsa.api.biz.common.BaseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCategoryName() {
        String name = "B";

        Category category = Category.of(name);

        assertNotNull(category);
        assertEquals(name, category.getName());
        assertEquals(BaseEntity.UseYn.Y, category.getUseYn());
        assertEquals(Const.SYSTEM, category.getRegId());
        assertEquals(Const.SYSTEM, category.getModifyId());
        assertNull(category.getSortSeqNo());
    }

    @Test
    public void testCreateCategoryWithNameAndSortSeqNo() {
        String name = "B";
        Long sortSeqNo = 1L;

        Category category = Category.of(name, sortSeqNo);

        assertNotNull(category);
        assertEquals(name, category.getName());
        assertEquals(BaseEntity.UseYn.Y, category.getUseYn());
        assertEquals(Const.SYSTEM, category.getRegId());
        assertEquals(Const.SYSTEM, category.getModifyId());
        assertNotNull(category.getSortSeqNo());
    }
}
