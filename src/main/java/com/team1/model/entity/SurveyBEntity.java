package com.team1.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "surveyb")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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




}
