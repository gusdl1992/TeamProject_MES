package com.team1.controller.membercontroller;


import com.team1.model.dto.MemberDto;
import com.team1.service.memberserivce.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
//@CrossOrigin("http://localhost:3000") // ********* 요청 근원지를 교차 허용(3000번지에서 8080에 요청 가능)
public class MemberController {

    @Autowired
    MemberService memberService;
    @PostMapping("/signup/post.do")
    public boolean doSignupPost(@RequestBody MemberDto memberDto){ //회원가입
        System.out.println(memberDto);
        System.out.println("안녕");
        return memberService.doSignupPost(memberDto);
    }

    @PostMapping("/login/post.do")
    public boolean doLoginPost(MemberDto memberDto){ //로그인
        System.out.println(memberDto);
        System.out.println("안녕");
        return memberService.doLoginPost(memberDto);
    }

    @GetMapping("/logout/get.do")   //로그아웃
    public boolean doLogoutGet(){
        return memberService.doLogoutGet();
    }

    // 회원 정보 가져오기.
    @GetMapping("/login/info/get.do")
    public MemberDto doLoginInfo(){
        return memberService.doLogininfo();
    }


    @GetMapping("/find/email/get.do") //수업시간에한거
    public boolean getfindMemail(String memail){
        return memberService.getfindMemail(memail);
    }


}
