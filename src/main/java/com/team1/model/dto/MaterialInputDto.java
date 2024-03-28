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
public class MaterialInputDto extends BaseTimeDto {

    private int mipno;

    private SurveyDto surveyEntity;

    private ProductDto productEntity;

    private MemberDto inputmemberEntity;

    private MemberDto checkmemberDto;

    public MaterialInputEntity toEntity(){
        return MaterialInputEntity.builder()
                .productEntity(this.productEntity.toEntity())
                .surveyEntity(this.surveyEntity.toEntity())
                .mipno(this.mipno)
                .inputmemberEntity(this.inputmemberEntity.toEntity())
                .checkmemberEntity(this.checkmemberDto.toEntity())

                .build();

    }
}
