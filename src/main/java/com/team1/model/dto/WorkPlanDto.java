package com.team1.model.dto;

import com.team1.model.entity.BaseTime;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.WorkPlanEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlanDto extends BaseTimeDto {

    private int wno; //  식별번호

    private int wcount; // 작업 수량

    private LocalDateTime wstarttime; // 공정 시작일

    private LocalDateTime wendtime; // 납기 일

    private int wstate; // 보고서 진행상황

    private ProductDto productDto;


    // - 엔티티를 dto로 변환하는 메소드
    public WorkPlanEntity toEntity() {
        return WorkPlanEntity.builder()
                .wno(this.wno)
                .wcount(this.wcount)
                .wstarttime(this.wstarttime)
                .wendtime(this.wendtime)
                .wstate(this.wstate)
                .productEntity(this.productDto.toEntity())
                .build();
    }


}

