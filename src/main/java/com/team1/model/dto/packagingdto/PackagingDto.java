package com.team1.model.dto.packagingdto;

import com.team1.model.dto.BaseTimeDto;
import com.team1.model.dto.ProductDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PackagingDto extends BaseTimeDto {

    private int pgno; // 식별번호

    private ProductDto productDto; // 제품 테이블 가져오기

    private int pgcount; // 수량

    private int mno; // 등록자
}
