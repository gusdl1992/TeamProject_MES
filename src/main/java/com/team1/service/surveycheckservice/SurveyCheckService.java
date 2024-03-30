package com.team1.service.surveycheckservice;

import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.repository.MemberRepository;
import com.team1.model.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SurveyCheckService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    MemberRepository memberRepository;

    // 1. 계량데이터 가져오기
    public Map< Object , Object >  surveyCheckView(){
        System.out.println("SurveyCheckService.surveyCheckView");
        
        // 계량 과 계량한 원자재 , 레시피 이름 및 필요량 가져오기
        List<  Map< Object , Object> > result1 = surveyRepository.findBySurveyCheckSQL(1,1);
        System.out.println("result1 = " + result1);

        // 현재 계량 번호와 비교하여 할일에서 수량 가져오기.
        Map<Object , Object> result2 = surveyRepository.findBySurveyCheckCountSQL(1);
        System.out.println("result2 = " + result2);


        Map< Object , Object > result  = new HashMap<>();
        result.put( "원료계량" , result1 );
        result.put( "생산계획" , result2 );



        Map<String, Object> retrievedInnerMap = (Map<String, Object>) result.get("생산계획");

        if (retrievedInnerMap != null) {
            Integer value = (Integer) retrievedInnerMap.get("pno");
            System.out.println("Value: " + value); //
            Integer sno = (Integer) retrievedInnerMap.get("sno");
            System.out.println("sno = " + sno);
            String cdate = retrievedInnerMap.get("cdate").toString();
            System.out.println("cdate = " + cdate);
            String udate = retrievedInnerMap.get("udate").toString();
            System.out.println("udate = " + udate);
        } else {
            System.out.println("Inner map not found");
        }



        // 외부 Map에서 List<Map> 가져오기
        List<Map<String, Object>> innerList = (List<Map<String, Object>>) result.get("원료계량");

        // 내부 List에서 Map 순회
        if (innerList != null) {
            for (Map<String, Object> innerMap : innerList) {
                System.out.println("원료쪽");
                Integer pno = (Integer) innerMap.get("pno");
                System.out.println("pno: " + pno); //
                Integer reno = (Integer) innerMap.get("reno");
                System.out.println("reno = " + reno);
                Integer reamount = (Integer) innerMap.get("reamount");
                System.out.println("reamount = " + reamount);
                Integer rmno = (Integer) innerMap.get("rmno");
                System.out.println("rmno = " + rmno);
                Integer sbcount = (Integer) innerMap.get("sbcount");
                System.out.println("sbcount = " + sbcount);
                String rmname = (String) innerMap.get("rmname");
                System.out.println("rmname = " + rmname);
                String cdate = innerMap.get("cdate").toString();
                System.out.println("cdate = " + cdate);
                String udate = innerMap.get("udate").toString();
                System.out.println("udate = " + udate);
            }
        } else {
            System.out.println("Inner list not found");
        }

        return result;

    }

    // 2. 검사 완료 체크 시 검사 완료자 데이터 저장
    public boolean surveyCheck(int sno , int mno){
        try {
            Optional<SurveyEntity> optionalsurveyEntity = surveyRepository.findById(sno);
            System.out.println("surveyEntity = " + optionalsurveyEntity);
            // 2. 찾은 엔티티가 존재하지 않으면
            if (!optionalsurveyEntity.isPresent()) {
                return false;
            }
            // 엔티티가 존재하면 엔티티 꺼내기
            SurveyEntity surveyEntity = optionalsurveyEntity.get();
            // 엔티티에 멤버 엔티티 를 찾아서 멤버 엔티티 mno 값 넣기
            surveyEntity.setCheckmemberEntity(memberNameCheck(mno));
            System.out.println("surveyEntity = " + surveyEntity);
            surveyRepository.save(surveyEntity);
            return true;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }

    // mno 로 사원 엔티티 가져와서 리턴
    public MemberEntity memberNameCheck(int mno){
        // mno 로 리포지토리 접근하여 사원 Entity 가져오기
        Optional<MemberEntity> memberEntity = memberRepository.findById(mno);
        // 엔티티가 존재하는지 체크
        if (memberEntity.isPresent()){
            // 엔티티 존재시 가져온 엔티티 겟 
            MemberEntity member = memberEntity.get();
            // 사원 이름 리턴
            return member;
        }
        return null;
    }

}

