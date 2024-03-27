package com.team1.model.dto;

import com.team1.model.entity.RawMaterialEntity;
import jakarta.persistence.Column;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RawMaterrialDto {
    private int rmno;
    private String rmname;
    private int rmquantity;

    public RawMaterialEntity toEntity() {
        return RawMaterialEntity.builder()
                .rmno(this.rmno)
                .rmname(this.rmname)
                .rmquantity(this.rmquantity)
                .build();
    }
}
