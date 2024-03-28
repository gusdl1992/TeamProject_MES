package com.team1.model.dto;

import com.team1.model.entity.BaseTime;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.WorkPlanEntity;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlanDto extends BaseTime {

    private int wno; //  식별번호

    private int wcount; // 작업 수량

    private ProductEntity productEntity;




    // - 엔티티를 dto로 변환하는 메소드
    public WorkPlanEntity toEntity() {
        return WorkPlanEntity.builder()
                .wno(this.wno)
                .wcount(this.wcount)
                .productEntity(this.productEntity)
                .build();
    }


}

