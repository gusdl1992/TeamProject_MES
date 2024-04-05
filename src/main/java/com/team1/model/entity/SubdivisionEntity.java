package com.team1.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "subdivision")
@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubdivisionEntity extends BaseTime{//class start
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sdno;       // 식별번호 (소분 테이블)

    @ManyToOne
    @JoinColumn(name = "mfno")
    private ManufacturingEntity manufacturingEntity;

    @ManyToOne
    @JoinColumn(name = "inputmno")
    private MemberEntity inputmemberEntity; // 등록자

    @ManyToOne
    @JoinColumn(name = "checkmno")
    private MemberEntity checkmemberEntity; // 검사자

    private int failCount;      // 불량품 개수

    private int successCount;   // 성공수량

    


}//class end
