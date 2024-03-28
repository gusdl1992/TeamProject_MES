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
public class RecipeDto extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reno;

    @Column(nullable = false)
    private double reamount;


    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "rmno")
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
