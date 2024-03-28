package com.team1.controller;

import com.team1.model.dto.WorkPlanDto;
import com.team1.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {


    @Autowired
    private SurveyService surveyService;

    // workplan 정보 가져오기
    @GetMapping("/workplaninfo.do")
    public List<WorkPlanDto> workPlanDtoList (){
        return surveyService.workPlanDtoList();
    }

}//class end
