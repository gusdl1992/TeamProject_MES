package com.team1.model.dto;


import com.team1.model.entity.BaseTime;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RecipeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto extends BaseTimeDto {

    private int reno;
    private int reamount;
    private int pno;
    private int rmno;

    private ProductDto productDto;
    private List<RawMaterrialDto> rawMaterrialDto;



}
