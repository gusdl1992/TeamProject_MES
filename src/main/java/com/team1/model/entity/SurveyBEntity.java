package com.team1.model.entity;

import com.team1.model.dto.SurveyBDto;
import com.team1.model.dto.SurveyDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "surveyb")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class SurveyBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sbno;

    private int sbcount;

    @ManyToOne
    @JoinColumn(name = "rmno")
    private RawMaterialEntity rawMaterialEntity;

    @ManyToOne
    @JoinColumn(name = "sno")
    private SurveyEntity surveyEntity;

    public SurveyBDto toDto(){ // R
        return SurveyBDto.builder()
                .rmname(this.rawMaterialEntity.getRmname())
                .sbcount(this.sbcount)
                .sno(this.surveyEntity.getSno())
                .build();
    }





}
