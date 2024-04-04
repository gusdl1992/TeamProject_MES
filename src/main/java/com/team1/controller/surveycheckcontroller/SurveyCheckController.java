package com.team1.controller.surveycheckcontroller;

import com.team1.model.dto.surveyCheckDto.SurveyCheckOutDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.service.surveycheckservice.SurveyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/survey")
public class SurveyCheckController {

    @Autowired
    SurveyCheckService surveyCheckService;

    // 1. 계량데이터 가져오기
    @GetMapping("/check/get.do")
    public Map< Object , Object >  surveyCheckView(){
        System.out.println("SurveyCheckController.surveyCheckView");
        return surveyCheckService.surveyCheckView();
    }

    // 워크플랜을 이용해서 데이터 출력 ( sno 번호 제품명 계량날짜 상태 )
    @GetMapping("/check/work/get.do")
    public List<WorkPlanEntity> roadCheckWorkState(){
        System.out.println("SurveyCheckController.roadCheckWorkState");
        return surveyCheckService.roadCheckWorkState();
    }

    // Survey 이용 하여 sno번호 제품명 계량날짜 계량원 상태 가져오기
    @GetMapping("/check/survey/get.do")
    public List<SurveyCheckOutDto> roadCheckSurvey(){
        System.out.println("SurveyCheckController.roadCheckSurvey");
        return surveyCheckService.roadCheckSurvey();
    }



    // 2. 검사 완료 체크 시 검사 완료자 데이터 저장
    @PutMapping("/check/complete/put.do")
    public boolean surveyCheck(int sno , int mno){ // 세션 저장 했다고 치고 작업

        return surveyCheckService.surveyCheck(sno , mno);
    }





}
