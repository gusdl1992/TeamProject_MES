package com.team1.controller.workplancontroller;


import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.SurveyRepository;
import com.team1.service.SurveyService;
import com.team1.service.workplanservice.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wp")
public class WorkPlanController {

    @Autowired
    WorkPlanService workPlanService;

    @PostMapping("/write/post.do")
    public boolean postWPWriteDo(WorkPlanDto workPlanDto){
        return workPlanService.postWPWriteDo(workPlanDto);
    }


    @GetMapping("/list/get.do")
    public List<WorkPlanDto> findWPList(){
        return workPlanService.findWPList();
    }

    @GetMapping("/fidsno/get.do")
    public int findSno(int wno){
        System.out.println("임시테스트용"+wno);
        return workPlanService.findSno(wno);
    }
}
