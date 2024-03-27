package com.team1.model.entity;


import com.team1.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(nullable = false,unique = true)
    private String mid;

    @Column(nullable = false)
    private String mpw;

    private int pno; // 임시 파트번호

    public MemberDto toDto(){
        return MemberDto.builder().mno(this.mno).mid(this.mid).mpw(this.mpw).pno(this.pno).build();

    }
}
