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
    private int mipno;


    @ManyToOne
    @JoinColumn(name = "wno")
    private WorkPlanEntity workPlanEntity;

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    public MaterialInputDto toDto(){
        return MaterialInputDto.builder()
                .productEntity(this.productEntity)
                .workPlanEntity(this.workPlanEntity)
                .mipno(this.mipno)
                .memberEntity(this.memberEntity)
                .build();

    }
}
