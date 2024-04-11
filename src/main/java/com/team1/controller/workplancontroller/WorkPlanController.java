package com.team1.controller.workplancontroller;


import com.team1.model.dto.ManufacturingDto.ManufacturingDto;
import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.SurveyRepository;
import com.team1.service.SurveyService;
import com.team1.service.manufacturingService.ManufacturingService;
import com.team1.service.workplanservice.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wp")
public class WorkPlanController {

    @Autowired
    WorkPlanService workPlanService;

    @Autowired
    ManufacturingService manufacturingService;
    @PostMapping("/write/post.do")
    public boolean postWPWriteDo(){
        return workPlanService.postWPWriteDo();
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
    @GetMapping("/fidmipno/get.do")
    public int findmipno(int wno){
        return workPlanService.findmipno(wno);
    }

    @GetMapping("/manu/get.do")
    public ManufacturingDto findmap(@RequestParam int mipno){
        System.out.println("\"\" = " + "안녕");
        return manufacturingService.findbymipno(mipno);
    }
}
