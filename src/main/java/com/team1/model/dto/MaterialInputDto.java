package com.team1.model.dto;


import com.team1.model.entity.*;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MaterialInputDto extends BaseTime {

    private int mipno;

    private WorkPlanEntity workPlanEntity;

    private ProductEntity productEntity;

    private MemberEntity memberEntity;

    public MaterialInputEntity toEntity(){
        return MaterialInputEntity.builder()
                .productEntity(this.productEntity)
                .workPlanEntity(this.workPlanEntity)
                .mipno(this.mipno)
                .memberEntity(this.memberEntity)
                .build();

    }
}
