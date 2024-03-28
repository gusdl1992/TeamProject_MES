package com.team1.service;

import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SurveyService {

    // workplan 정보 가져오기
    @GetMapping("/workplaninfo.do")
    public List<WorkPlanDto> workPlanDtoList (){
//        List<MemberEntity> memberEntityList = memberEntityRepository.findAll();
//        List<WorkPlanEntity> workPlanEntityList = workPlanEntityRepository.findAll();
        return null;
    }


}//class end
