package com.team1.model.dto;


import com.team1.model.entity.BaseTime;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RecipeEntity;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto extends BaseTimeDto {

    private int reno;

    private double reamount;

    private ProductEntity productEntity;

    private RawMaterialEntity rawMaterialEntity;

    public RecipeEntity toEntity(){
        return RecipeEntity.builder()
                .productEntity(this.productEntity)
                .rawMaterialEntity(this.rawMaterialEntity)
                .reamount(this.reamount)
                .reno(this.reno)
                .build();

    }

}
