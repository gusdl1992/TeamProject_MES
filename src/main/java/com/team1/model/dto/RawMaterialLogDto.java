package com.team1.model.dto;

import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RawMaterialLogEntity;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialLogDto {

    private int rmlno; // 원자재로그 식별번호

    private int rmcount; // 원자재 로그가 얼마나 들어갔는지

    private RawMaterialEntity rawMaterialEntity;


    public RawMaterialLogEntity toEntity(){
        return RawMaterialLogEntity.builder().rmlno(this.rmlno).rmcount(this.rmcount).rawMaterialEntity(this.rawMaterialEntity)
                .build();

    }
}
