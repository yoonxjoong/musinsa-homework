package org.musinsa.api.biz.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.entity.Brand;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandDto {
    /**
     * 브랜드 번호
     */
    private Long brandAutoSn;

    /**
     * 정렬 번호
     */
    private Long sortSeqNo;

    /**
     * 브랜드명
     */
    private String name;

    /**
     * 사용여부
     */
    private String useYn;

    public static BrandDto of(Brand brand) {
        return BrandDto.builder()
                .brandAutoSn(brand.getBrandAutoSn())
                .sortSeqNo(brand.getSortSeqNo())
                .name(brand.getName())
                .useYn(String.valueOf(brand.getUseYn()))
                .build();
    }
}
