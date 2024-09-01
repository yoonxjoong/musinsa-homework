package org.musinsa.api.biz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.musinsa.api.biz.Const;
import org.musinsa.api.biz.common.BaseEntity;

/**
 * 브랜드 객체 클래스
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand extends BaseEntity {
    /**
     * 브랜드 자동 생성 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 등록 사용자
     */
    private String regId;

    /**
     * 변경 사용자
     */
    private String modifyId;

    @Builder
    public Brand(String name, Long sortSeqNo) {
        this.name = name;
        this.useYn = UseYn.Y;
        this.sortSeqNo = sortSeqNo;
        this.regId = Const.SYSTEM;
        this.modifyId = Const.SYSTEM;
    }

    @Builder
    public Brand(String name) {
        this.name = name;
        this.useYn = UseYn.Y;
        this.regId = Const.SYSTEM;
        this.modifyId = Const.SYSTEM;
    }

    public static Brand of(String name) {
        return Brand.builder().name(name).build();
    }

    public static Brand of(String name, Long sortSeqNo) {
        return Brand.builder().name(name).sortSeqNo(sortSeqNo).build();
    }

    /**
     * 브랜드 정보 변경
     * @param targetBrand 변경할 브랜드
     */
    public void update(Brand targetBrand) {
        this.name = targetBrand.getName();
        this.sortSeqNo = targetBrand.getSortSeqNo();
        this.useYn = targetBrand.getUseYn();
        this.modifyId = Const.SYSTEM;
    }
}
