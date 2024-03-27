package com.team1.model.entity;

import com.team1.model.dto.RawMaterialLogDto;
import com.team1.model.dto.RawMaterrialDto;
import jakarta.persistence.*;
import lombok.*;

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

    private int rmcount; // 원자재 로그가 얼마나 들어갔는지
    @JoinColumn( name = "rmno")
    @ManyToOne
    private RawMaterialEntity rawMaterialEntity;

    // - 엔티티를 dto로 변환하는 메소드
    public RawMaterialLogDto toDto() {
        return RawMaterialLogDto.builder()
                .rmlno(this.rmlno)
                .rmcount(this.rmcount)
                .rawMaterialEntity(this.rawMaterialEntity)
                .build();
    }


}
