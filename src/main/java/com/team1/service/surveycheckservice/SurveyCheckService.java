package com.team1.service.surveycheckservice;

import com.team1.model.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyCheckService {

    @Autowired
    SurveyRepository surveyRepository;

    // 1. 계량데이터 가져오기
    public Map< Object , Object >  surveyCheckView(){
        System.out.println("SurveyCheckService.surveyCheckView");
        
        // 계량 과 계량한 원자재 , 레시피 이름 및 필요량 가져오기
        List<  Map< Object , Object> > result1 = surveyRepository.findBySurveyCheckSQL(1,1);
        System.out.println("result1 = " + result1);

        // 현재 계량 번호와 비교하여 할일에서 수량 가져오기.
        Map<Object , Object> result2 = surveyRepository.findBySurveyCheckCountSQL(1);
        System.out.println("result2 = " + result2);
        //
        //result1.add(result2);

        Map< Object , Object > result  = new HashMap<>();
        result.put( "원료계량" , result1 );
        result.put( "생산계획" , result2 );
        return result;

    }

}
