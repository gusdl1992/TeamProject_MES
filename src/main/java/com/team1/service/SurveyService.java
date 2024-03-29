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

/*

    박시현 리포지토리 에서 쿼리문 사용 예제 컨트롤러 만들어서 시험 예정
    @Autowired
    private MyRepository myRepository;

    public List<Object[]> fetchMyData() {
        String jpql = "SELECT s, w, r, rm " +
                      "FROM Survey s " +
                      "JOIN Workplan w ON s.wno = w.wno " +
                      "JOIN Recipe r ON w.pno = r.pno " +
                      "JOIN RawMaterial rm ON r.rmno = rm.rmno " +
                      "WHERE r.pno = :pno";
        return myRepository.getEntityManager()
                            .createQuery(jpql)
                            .setParameter("pno", 1)
                            .getResultList();
    }


*/