package com.team1.model.entity;

import com.team1.model.dto.RawMaterrialDto;
import com.team1.model.dto.SurveyDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "survey")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SurveyEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private int sno; //  식별번호
    @Column( nullable = false)
    private int samount; // 수량


    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity; // 담당자

    @ManyToOne
    @JoinColumn(name = "wno")
    private WorkPlanEntity workPlanEntity;



    // - 엔티티를 dto로 변환하는 메소드
    public SurveyDto toDto() {
        return SurveyDto.builder()
                .sno(this.sno)
                .samount(this.samount)
                .memberEntity(this.memberEntity)
                .workPlanEntity(this.workPlanEntity)
                .build();
    }


}

