package com.team1.service;

import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.WorkPlanEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private WorkPlanEntityRepository workPlanEntityRepository;

    // workplan 정보 가져오기
    public List<WorkPlanDto> workPlanDtoList (){
        // 반환할꺼 담을 DTO 리스트
        List<WorkPlanDto> workPlanDtoList = new ArrayList<>();

        // JPA에서 데이터 호출하기
        List<WorkPlanEntity> workPlanEntityList = workPlanEntityRepository.findAll();

        for (int i = 0; i < workPlanEntityList.size(); i++) {
            workPlanDtoList.add(workPlanEntityList.get(i).toDto());
        }
        return workPlanDtoList;
    }

    // workplan 식별번호로 정보 가져오기
    public WorkPlanDto workPlanDto (int wno){

        // JPA에서 데이터 호출하기
        WorkPlanEntity workPlanEntity = workPlanEntityRepository.findBywno(wno);

        return workPlanEntity.toDto();
    }

}//class end
