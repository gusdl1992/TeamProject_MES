package com.team1.model.entity;

import com.team1.model.dto.RawMaterrialDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rawmaterial")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private int rmno; // 원자재 식별번호
    @Column( length = 30 , nullable = false)
    private String rmname; // 원자재 이름
    @Column( columnDefinition = " int default 0 " )
    private int rmquantity; // 원자재 분량

    // - 엔티티를 dto로 변환하는 메소드
    public RawMaterrialDto toDto() {
        return RawMaterrialDto.builder()
                .rmno(this.rmno)
                .rmname(this.rmname)
                .rmquantity(this.rmquantity)
                .build();
    }


}

