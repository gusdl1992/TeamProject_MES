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
    private int mno; // 회원 식별키

    @Column(nullable = false,unique = true)
    private String mid; // 회원 아이디

    @Column(nullable = false)
    private String mpw; // 회원 비밀번호

    @Column(nullable = false)
    private String mname; // 회원 이름

    private int pno; // 임시 파트번호 ( 어떤 파티에서 일하는지 )

    public MemberDto toDto(){
        MemberDto memberDto = MemberDto.builder().
                mno(this.mno).
                mid(this.mid).
                mpw(this.mpw).
                pno(this.pno).
                mname(this.mname).build();
        memberDto.setCdate(this.cdate);
        memberDto.setUdate(this.udate);
        return memberDto;

    }
}
