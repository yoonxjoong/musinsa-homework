package org.musinsa.api.biz.request;

import lombok.Builder;
import lombok.Data;
import org.musinsa.api.biz.common.BaseEntity;
import org.musinsa.api.biz.entity.Brand;

@Data
@Builder
public class BrandSaveRequest {
    /**
     * 브랜드명
     */
    private String name;

    /**
     * 정렬 번호
     */
    private Long sortSeqNo;

    /**
     * 사용여부
     */
    private BaseEntity.UseYn useYn;

    public Brand toBrand() {
        return Brand.builder()
                .name(name)
                .sortSeqNo(sortSeqNo)
                .build();
    }
}
