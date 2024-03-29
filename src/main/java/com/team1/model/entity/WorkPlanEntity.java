package com.team1.model.entity;

import com.team1.model.dto.WorkPlanDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workplan")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlanEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private int wno; //  식별번호
    @Column( nullable = false)
    private int wcount; // 작업 수량
    @Column( nullable = false )
    private LocalDateTime wstarttime; // 공정 시작일
    @Column( nullable = false )
    private LocalDateTime wendtime; // 납기 일
    @Column( nullable = false , columnDefinition = " int default 0 ")
    private int wstate; // 보고서 진행상황
    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity; // 제품 테이블 가져옴 ( 제품 이름 )



    // - 엔티티를 dto로 변환하는 메소드
    public WorkPlanDto toDto() {
        WorkPlanDto workPlanDto = WorkPlanDto.builder()
                .wno(this.wno)
                .wcount(this.wcount)
                .wstarttime(this.wstarttime)
                .wendtime(this.wendtime)
                .wstate(this.wstate)
                .pno(this.productEntity.getPno())
                .build();
        workPlanDto.setCdate(this.cdate);
        workPlanDto.setUdate(this.udate);
        return workPlanDto;
    }


}

