package com.team1.controller.subdivisioncontroller;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SubDivisionDto;
import com.team1.service.memberserivce.MemberService;
import com.team1.service.subdivisionservice.SubDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subdivision")
public class SubDivisionController {
    @Autowired
    private SubDivisionService subDivisionService;
    @Autowired
    private MemberService memberService;

    // 소분 보고서 작성
    @PostMapping("/input/post.do")
    public boolean doSubDivisionInputPost(@RequestParam int mfno , int failcount , int successcount){
        return subDivisionService.doSubDivisionInputPost(mfno,failcount,successcount);
    }

    // 소분 모두 출력
    @GetMapping("/allinfo/get.do")
    public List<SubDivisionDto> doSubDivisionAllinfoGet(){
        return subDivisionService.doSubDivisionAllinfoGet();
    }

    // 벌크 정보 출력
    @GetMapping("/manufacturing/get.do")
    public List<Object> doManufacturingAllinfoGet(){
        List<Object> result = subDivisionService.doManufacturingAllinfoGet();
        System.out.println("result = " + result);
        return result;
    }

    // 품질 검사
    @PutMapping("/confirm.do")
    public boolean doSubDivisionConfirm(SubDivisionDto subDivisionDto){
        System.out.println("subDivisionDto = " + subDivisionDto);
        int mno = memberService.doLogininfo().getMno();
        int sdno = subDivisionDto.getSdno();
        int sdstate = subDivisionDto.getSdstate();
        return subDivisionService.doSubDivisionConfirm(mno , sdno , sdstate);
    }
}
