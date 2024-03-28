package com.team1.model.dto;

import com.team1.model.entity.BaseTime;
import com.team1.model.entity.RawMaterialEntity;
import jakarta.persistence.Column;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RawMaterrialDto extends BaseTimeDto {
    private int rmno;
    private String rmname;


    public RawMaterialEntity toEntity() {
        return RawMaterialEntity.builder()
                .rmno(this.rmno)
                .rmname(this.rmname)
                .build();
    }
}
