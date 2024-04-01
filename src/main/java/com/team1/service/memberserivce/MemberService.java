package com.team1.service.memberserivce;

import com.team1.model.dto.MemberDto;
import com.team1.model.entity.MemberEntity;
import com.team1.model.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    //5.아이디로(이메일) 중복검사
    public boolean getfindMemail(String memail){
        boolean result;
        result = memberRepository.existsByMid(memail);
        return result;
    };



    public boolean doSignupPost( MemberDto memberDto){

        boolean result = getfindMemail(memberDto.getMid());
        if(!result){
            return false;
        }

        MemberEntity savedEntity = memberRepository.save(memberDto.toEntity());

        //3.엔티티 생성이 되었는지 아닌지 확인 (PK)
        if(savedEntity.getMno()>0) {
            return true;
        }
        return false;
    }

    //* 로그인 했다는 증거/기록

    @Autowired private HttpServletRequest request;

    // 2.로그인
    public boolean doLoginPost(MemberDto memberDto){ //로그인

        MemberEntity memberEntity1 = memberRepository.findByLoginSql(memberDto.getMid(), memberDto.getMpw());
        if(memberEntity1 == null){
            return false;
        }
        System.out.println(memberEntity1);
        request.getSession().setAttribute("logindto",memberEntity1.toDto());
//        findByMyBoardList(); // 내가쓴글 리스트
        return true;
    }

    //3로그아웃
    public boolean doLogoutGet(){
        request.getSession().setAttribute("logindto",null);
        return true;
    }
    //4.현재 로그인 회원정보 호출 (세션 값 반환/호출)
    public MemberDto doLogininfo(){
        Object object = request.getSession().getAttribute("logindto");
        if(object != null){
            return (MemberDto) object;
        }
        return null;
    }
}
/*
    Optional 클래스
        -해당 객체가 null일수도있고 아닐수도있다

 */