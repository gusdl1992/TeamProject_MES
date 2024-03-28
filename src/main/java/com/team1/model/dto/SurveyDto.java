package com.team1.model.dto;

import com.team1.model.entity.BaseTime;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.entity.WorkPlanEntity;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto extends BaseTimeDto {

    private int sno; //  식별번호

    private int samount; // 수량

    private MemberEntity inputmemberEntity;

    private MemberEntity checkmemberEntity; // 담당자


    private WorkPlanEntity workPlanEntity;



    // - 엔티티를 dto로 변환하는 메소드
    public SurveyEntity toEntity() {
        return SurveyEntity.builder()
                .sno(this.sno)
                .samount(this.samount)
                .inputmemberEntity(this.inputmemberEntity)
                .checkmemberEntity(this.checkmemberEntity)
                .workPlanEntity(this.workPlanEntity)
                .build();
    }


}

