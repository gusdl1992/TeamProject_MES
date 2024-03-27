package com.team1.model.entity;


import com.team1.model.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(nullable = false)
    private String pname;

    public ProductDto toDto(){
        return ProductDto.builder().pno(this.pno).pname(this.pname).build();

    }

}
