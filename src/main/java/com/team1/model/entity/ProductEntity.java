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
    private int pno; // 제품 식별번호

    @Column(nullable = false)
    private String pname; // 제품 이름

    public ProductDto toDto(){
        ProductDto productDto = ProductDto.builder()
                .pno(this.pno)
                .pname(this.pname)
                .build();
        productDto.setCdate(this.cdate);
        productDto.setUdate(this.udate);
        return productDto;
    }

}
