package com.team1.model.entity;

import com.team1.model.dto.ExpirationDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity(name = "expiration")
@SuperBuilder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExpirationEntity extends BaseTime {
    //폐기 대기 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int epno;       // 식별번호 ()


    int pno; //프로덕트 번호 ?  <<<<<<<<<<<<<<<이 테이블은 input을 스케쥴러로 할 건데 productEntity를 넣어야 하는가에 대해 고민

    int plcount; //분량

    public ExpirationDTO toDto(){
        return ExpirationDTO.builder().epno(this.epno).pno(this.pno).plcount(this.plcount).cdate(this.cdate).udate(this.udate).build();
    }
}
