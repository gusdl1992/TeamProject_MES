package com.team1.model.dto;


import com.team1.model.entity.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MaterialInputDto extends BaseTimeDto {

    private int mipno;

    private SurveyDto surveyDto;

    private ProductDto productEntity;

    private MemberDto inputmemberEntity;

    private String checkmembername;

    public MaterialInputEntity toEntity(){
        return MaterialInputEntity.builder()
                .productEntity(this.productEntity.toEntity())
                .surveyEntity(this.surveyDto.toEntity())
                .mipno(this.mipno)
                .inputmemberEntity(this.inputmemberEntity.toEntity())

                .build();

    }
}
