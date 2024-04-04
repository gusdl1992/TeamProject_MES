package com.team1.controller.workplancontroller;


import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.service.workplanservice.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wp")
public class WorkPlanController {

    @Autowired
    WorkPlanService workPlanService;

    @GetMapping("/list/get.do")
    public List<WorkPlanDto> findWPList(){
        return workPlanService.findWPList();
    }
}
