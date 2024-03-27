package com.team1.model.entity;


import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materialinput")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MaterialInputEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mipno; // 원료 투입 식별번호


    @ManyToOne
    @JoinColumn(name = "wno")
    private WorkPlanEntity workPlanEntity; // 지시일자를 따오기위해 작업계획 테이블을 가져옴

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity; // 어떤 제품인지를 알기위해 제품테이블을 가져옴

    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity; // 사원번호 따오기 위해 회원테이블 가져옴

    public MaterialInputDto toDto(){
        return MaterialInputDto.builder()
                .productEntity(this.productEntity)
                .workPlanEntity(this.workPlanEntity)
                .mipno(this.mipno)
                .memberEntity(this.memberEntity)
                .build();

    }
}
