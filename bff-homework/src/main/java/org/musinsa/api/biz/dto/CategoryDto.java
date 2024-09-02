package org.musinsa.api.biz.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.entity.Brand;
import org.musinsa.api.biz.entity.Category;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    /**
     * 카테고리 번호
     */
    private Long categoryAutoSn;

    /**
     * 정렬 번호
     */
    private Long sortSeqNo;

    /**
     * 카테고리명
     */
    private String name;

    /**
     * 사용여부
     */
    private String useYn;

    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .categoryAutoSn(category.getCategoryAutoSn())
                .sortSeqNo(category.getSortSeqNo())
                .name(category.getName())
                .useYn(String.valueOf(category.getUseYn()))
                .build();
    }
}
