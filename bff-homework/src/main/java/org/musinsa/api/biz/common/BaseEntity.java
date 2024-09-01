package org.musinsa.api.biz.common;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA의 엔티티 클래스가 상속받을 경우 자식 클래스에게 매핑 정보를 전달
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "reg_dtm", updatable = false, nullable = false) // 생성 시간, 업데이트 불가, null 불가
    private LocalDateTime regDtm;

    @LastModifiedDate
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "modify_dtm", nullable = false) // 수정 시간, null 불가
    private LocalDateTime modifyDtm;


    @Enumerated(EnumType.STRING)
    public UseYn useYn;

    public enum UseYn {
        Y, N;
    }
}
