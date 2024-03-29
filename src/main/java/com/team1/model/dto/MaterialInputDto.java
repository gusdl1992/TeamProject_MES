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

    private MemberDto checkmemberDto;

    public MaterialInputEntity toEntity(){ // C
        return MaterialInputEntity.builder()
                .surveyEntity(surveyDto.toEntity())
                .build();

    }
}
