package com.team1.service.workplanservice;


import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.WorkPlanEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkPlanService {

    @Autowired
    WorkPlanEntityRepository workPlanEntityRepository;

    public List<WorkPlanDto> findWPList(){
        return workPlanEntityRepository.findAll().stream().map(WorkPlanEntity::toDto).collect(Collectors.toList());
    }


}
