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