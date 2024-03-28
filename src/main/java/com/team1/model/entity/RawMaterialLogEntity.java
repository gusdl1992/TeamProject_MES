package com.team1.model.entity;

import com.team1.model.dto.RawMaterialLogDto;
import com.team1.model.dto.RawMaterrialDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rawmateriallog")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterialLogEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rmlno; // 원자재로그 식별번호

    private int rmlcount; // 이번에 원자재가 얼마나 들어갔는지


    @JoinColumn( name = "rmno")
    @ManyToOne
    private RawMaterialEntity rawMaterialEntity; // 원자재 테이블 가져옴 ( 원자재 이름 )

    // - 엔티티를 dto로 변환하는 메소드
    public RawMaterialLogDto toDto() {
        RawMaterialLogDto rawMaterialLogDto = RawMaterialLogDto.builder()
                .rmlno(this.rmlno)
                .rmlcount(this.rmlcount)
                .rawMaterialEntity(this.rawMaterialEntity)
                .build();
        rawMaterialLogDto.setCdate(this.cdate);
        rawMaterialLogDto.setUdate(this.udate);
        return rawMaterialLogDto;
    }



}
