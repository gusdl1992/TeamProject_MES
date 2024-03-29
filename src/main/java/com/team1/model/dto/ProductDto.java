package com.team1.model.dto;


import com.team1.model.entity.BaseTime;
import com.team1.model.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseTimeDto {

    private int pno;


    private String pname;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .pno(this.pno)
                .pname(this.pname)
                .build();

    }

}
