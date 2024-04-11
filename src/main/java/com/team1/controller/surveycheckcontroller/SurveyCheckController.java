package com.team1.controller.surveycheckcontroller;

import com.team1.model.dto.SurveyBDto;
import com.team1.model.dto.SurveyDto;
import com.team1.model.dto.surveyCheckDto.SurveyCheckOutDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.service.surveycheckservice.SurveyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/survey")
public class SurveyCheckController {

    @Autowired
    SurveyCheckService surveyCheckService;

    // 1. 계량데이터 가져오기 안씀
    @GetMapping("/check/get.do")
    public Map< Object , Object >  surveyCheckView(){
        return surveyCheckService.surveyCheckView();
    }

    // 워크플랜을 이용해서 데이터 출력 ( sno 번호 제품명 계량날짜 상태 )
    @GetMapping("/check/work/get.do")
    public List<WorkPlanEntity> roadCheckWorkState(){
        return surveyCheckService.roadCheckWorkState();
    }

    // Survey 이용 하여 sno번호 제품명 계량날짜 계량원 상태 가져오기
    @GetMapping("/check/survey/get.do")
    public List<SurveyCheckOutDto> roadCheckSurvey(){
        return surveyCheckService.roadCheckSurvey();
    }



    // 2. 검사 완료 체크 시 검사 완료자 데이터 저장
    @PutMapping("/check/complete/put.do")
    public boolean surveyCheck(SurveyDto surveyDto){ // 세션 저장 했다고 치고 작업
        int sno = surveyDto.getSno();
        int sstate = surveyDto.getSstate();
        return surveyCheckService.surveyCheck(sno , sstate);
    }





}
