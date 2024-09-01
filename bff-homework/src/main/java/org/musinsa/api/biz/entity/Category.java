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
 * 카테고리 객체 클래스
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    /**
     * 카테고리 자동 생성 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 등록 사용자
     */
    private String regId;

    /**
     * 변경 사용자
     */
    private String modifyId;

    @Builder
    public Category(String name, Long sortSeqNo) {
        this.name = name;
        this.useYn = UseYn.Y;
        this.sortSeqNo = sortSeqNo;
        this.regId = Const.SYSTEM;
        this.modifyId = Const.SYSTEM;
    }

    @Builder
    public Category(String name) {
        this.name = name;
        this.useYn = UseYn.Y;
        this.regId = Const.SYSTEM;
        this.modifyId = Const.SYSTEM;
    }

    public static Category of(String name) {
        return Category.builder().name(name).build();
    }

    public static Category of(String name, Long sortSeqNo) {
        return Category.builder().name(name).sortSeqNo(sortSeqNo).build();
    }
}
