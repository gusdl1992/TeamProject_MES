package com.team1.controller.surveycheckcontroller;

import com.team1.service.surveycheckservice.SurveyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/check")
    public Map< Object , Object >  surveyCheckView(){
        System.out.println("SurveyCheckController.surveyCheckView");
        return surveyCheckService.surveyCheckView();
    }



}