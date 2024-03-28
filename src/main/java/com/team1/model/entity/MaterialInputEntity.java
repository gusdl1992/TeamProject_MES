package com.team1.model.entity;


import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materialinput")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MaterialInputEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mipno; // 원료 투입 식별번호


    @ManyToOne
    @JoinColumn(name = "sno")
    private SurveyEntity surveyEntity; // 계량 테이블 보기

    @ManyToOne
    @JoinColumn(name = "pno")
    private ProductEntity productEntity; // 어떤 제품인지를 알기위해 제품테이블을 가져옴

    @ManyToOne
    @JoinColumn(name = "inputmno")
    private MemberEntity inputmemberEntity; // 사원번호 따오기 위해 회원테이블 가져옴

    @ManyToOne
    @JoinColumn(name = "checkmno")
    private MemberEntity checkmemberEntity; // 사원번호 따오기 위해 회원테이블 가져옴


    public MaterialInputDto toDto(){
        MaterialInputDto materialInputDto = MaterialInputDto.builder()
                .productEntity(this.productEntity.toDto())
                .surveyEntity(this.surveyEntity.toDto())
                .mipno(this.mipno)
                .inputmemberEntity(this.inputmemberEntity.toDto())
                .checkmemberDto(this.checkmemberEntity.toDto())
                .build();
        materialInputDto.setCdate(this.cdate);
        materialInputDto.setUdate(this.udate);
        return materialInputDto;
    }
}
