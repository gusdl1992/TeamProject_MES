package com.team1.model.entity;

import com.team1.model.dto.WorkPlanDto;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity; // 제품 테이블 가져옴 ( 제품 이름 )



    // - 엔티티를 dto로 변환하는 메소드
    public WorkPlanDto toDto() {
        return WorkPlanDto.builder()
                .wno(this.wno)
                .wcount(this.wcount)
                .productEntity(this.productEntity)
                .build();
    }


}

