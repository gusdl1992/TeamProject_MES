package com.team1.model.entity;


import com.team1.model.dto.ProductDto;
import com.team1.model.dto.RecipeDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipe")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity extends BaseTime{

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

    public RecipeDto toDto() {
        return RecipeDto.builder()
                .productEntity(this.productEntity)
                .rawMaterialEntity(this.rawMaterialEntity)
                .reamount(this.reamount)
                .reno(this.reno)
                .build();
    }

}
