package com.team1.model.entity;

import com.team1.model.dto.ManufacturingDto.ManufacturingDto;
import com.team1.model.dto.MaterialInputDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "manufacturing")
@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mfno;       // 식별번호 (제조(벌크) 테이블)

    @ManyToOne
    @JoinColumn(name = "mipno")
    private MaterialInputEntity materialInputEntity;

    @ManyToOne
    @JoinColumn(name = "inputmno")
    private MemberEntity inputmemberEntity; // 등록자

    @ManyToOne
    @JoinColumn(name = "checkmno")
    private MemberEntity checkmemberEntity; // 검사자

    public ManufacturingDto toDto(){
        return ManufacturingDto.builder()
                .mfno(this.mfno)
                .materialInputEntity(this.materialInputEntity.toDto())
                .inputmemberEntity(this.inputmemberEntity.toDto())
                .checkmemberEntity(this.checkmemberEntity.toDto())
                .cdate(this.cdate)
                .udate(this.udate)
                .build();
    }
}



