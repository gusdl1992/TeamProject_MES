package com.team1.service.surveycheckservice;

import com.team1.model.entity.*;
import com.team1.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SurveyCheckService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    WorkPlanEntityRepository workPlanEntityRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RecipeEntityRepository recipeEntityRepository;
    @Autowired
    SurveyBEntityRepository surveyBEntityRepository;

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

    // state 로 계량 완료 된것만 가져오기
    public List<WorkPlanEntity> roadCheckWorkState(){
        System.out.println("SurveyCheckService.roadCheckWorkState");
        List<WorkPlanEntity> workPlanEntityList = workPlanEntityRepository.findAll();
        List<WorkPlanEntity> workPlans = new ArrayList<>();
        for (int i = 0 ; i < workPlanEntityList.size() ; i++){
            if (workPlanEntityList.get(i).getWstate() == 1){
                workPlans.add(workPlanEntityList.get(i));
            }
        }
        System.out.println("workPlans = " + workPlans);
        return workPlans;
    }



    // 2. 검사 완료 체크 시 검사 완료자 데이터 저장
    public boolean surveyCheck(int sno , int mno){
        System.out.println("테스트 시작");
        SurveyEntity survey = surveyGetList(sno);
        WorkPlanEntity workPlan = workPlanGetList(survey.getWorkPlanEntity().getWno());
        ProductEntity product = productEntityList(workPlan.getProductEntity().getPno());
        List<RecipeEntity> recipeEntityList = recipeEntityList(workPlan.getProductEntity().getPno());
        List<SurveyBEntity> surveyBEntityList = surveyBEntityList(sno);


        boolean result = surveyChack(workPlan ,recipeEntityList ,surveyBEntityList);
        if (result){
            // 계량 체크가 유효성 검사가 모두 성공 했을 시 아래 문 실행.
            survey.setCheckmemberEntity(memberNameCheck(mno));
            surveyRepository.save(survey);
            return true;
        }else {
            // 계량 검사 유효성 검사 실패시 false 리턴.
            return false;
        }

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

    // survey 테이블 데이터 가져오기
    public SurveyEntity surveyGetList(int sno){
        List<SurveyEntity> surveyEntityList = surveyRepository.findAll();
        System.out.println("surveyEntityList = " + surveyEntityList);
        SurveyEntity survey = null;
        if (surveyEntityList != null){
            for (int i = 0 ; i < surveyEntityList.size() ; i++){
                System.out.println("surveyEntityList = " + surveyEntityList.get(i));
                if (surveyEntityList.get(i).getSno() == sno){
                    survey = surveyEntityList.get(i);
                }
            }
        }
        System.out.println("survey = " + survey);
        return survey;
    }

    // workplan 테이블 데이터 가져오기
    // workPlanEntity=WorkPlanEntity(wno=1, wcount=1000 wstate=0, productEntity=ProductEntity(pno=1, pname=수분크림))
    public WorkPlanEntity workPlanGetList(int wno){
        List<WorkPlanEntity> workPlanEntityList = workPlanEntityRepository.findAll();
        System.out.println("workPlanEntityList = " + workPlanEntityList);
        WorkPlanEntity workPlan = null;
        if (workPlanEntityList != null){
            for (int i = 0 ; i < workPlanEntityList.size() ; i++){
                System.out.println("workPlanEntityList = " + workPlanEntityList.get(i));
                if (workPlanEntityList.get(i).getWno() == wno){
                    workPlan = workPlanEntityList.get(i);
                }
            }
        }
        return workPlan;
    }

    // Product 테이블 데이터 가져오기
    // WorkPlanEntity(wno=1, wcount=1000, wstarttime=2024-03-20T10:00:12.123456, wendtime=2024-03-30T10:00:12.123456, wstate=0, productEntity=ProductEntity(pno=1, pname=수분크림))
    public ProductEntity productEntityList(int pno){
        List<ProductEntity> productEntityList = productRepository.findAll();
        System.out.println("productEntityList = " + productEntityList);
        ProductEntity product = null;
        if (productEntityList != null){
            for (int i = 0 ; i < productEntityList.size() ; i++){
                System.out.println("productEntityList = " + productEntityList.get(i));
                if (productEntityList.get(i).getPno() == pno){
                    product = productEntityList.get(i);
                }
            }
        }
        return product;
    }

    // recipe 테이블 데이터 가져오기
    public List<RecipeEntity> recipeEntityList(int pno){
        List<RecipeEntity> recipeEntityList = recipeEntityRepository.findAll();
        System.out.println("recipeEntityList = " + recipeEntityList);
        List<RecipeEntity> recipes = new ArrayList<>();
        if (recipeEntityList != null){
            for (int i = 0 ; i < recipeEntityList.size() ; i++){
                System.out.println("recipeEntityList = " + recipeEntityList.get(i));
                if (recipeEntityList.get(i).getProductEntity().getPno() == pno){
                    recipes.add(recipeEntityList.get(i));
                }
            }
        }
        return recipes;
    }

    // SurveyB 테이블 데이터 가져오기
    public List<SurveyBEntity> surveyBEntityList(int sno){
        List<SurveyBEntity> surveyBEntityList = surveyBEntityRepository.findAll();
        System.out.println("surveyBEntityList = " + surveyBEntityList);
        List<SurveyBEntity> surveyBs = new ArrayList<>();
        if (surveyBEntityList != null){
            for (int i = 0 ; i < surveyBEntityList.size() ; i++){
                System.out.println("recipeEntityList = " + surveyBEntityList.get(i));
                if (surveyBEntityList.get(i).getSurveyEntity().getSno() == sno){
                    surveyBs.add(surveyBEntityList.get(i));
                }
            }
        }
        return surveyBs;
    }

    // 원자재 계량 비교
    public boolean surveyChack(WorkPlanEntity workPlan ,List<RecipeEntity> recipeEntityList , List<SurveyBEntity> surveyBEntityList ){
        List<Boolean> result = new ArrayList<>();
        int 수량 = workPlan.getWcount();
        System.out.println("수량 = " + 수량);

        Map<Integer , Double> map1= new HashMap<>();
        Map<Integer , Double> map2 = new HashMap<>();


        // 레시피 MAP 에 비교를 위해 키 값 저장
        for (int i = 0 ; i < recipeEntityList.size() ; i++){
            map1.put(recipeEntityList.get(i).getRawMaterialEntity().getRmno(), (double) recipeEntityList.get(i).getReamount() * 수량);
            System.out.println("map1 = " + map1);
        }
        // 실제 계량한값 가져와 MAP 에 키 값 저장
        for (int i = 0 ; i < surveyBEntityList.size(); i++){
            // 계량한거 가져오기
            map2.put(surveyBEntityList.get(i).getRawMaterialEntity().getRmno() , (double) surveyBEntityList.get(i).getSbcount());
            System.out.println("map2 = " + map2);
        }

        // 맵의 크기가 같은지 검증
        if (map1.size() != map2.size()) {
            System.out.println("SurveyCheckService.chack Map Size 가 다름니다.");
            return false;
        }

        // 레시피 MAP 에 +- 1% 적용 하여 비교
        // 맵의 모든 키-값 쌍에 대해 반복
        for (Map.Entry<Integer, Double> entry : map1.entrySet()) {
            double num = entry.getValue() * 0.01;
            System.out.println("num = " + num);
            Integer key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
            
            // 레시피와 계량 값 비교 후 Boolean 배열에 저장
            if (map2.get(key) >= entry.getValue() - num && map2.get(key) <= entry.getValue() + num ){
                System.out.println("테스트 들어왔다");
                System.out.println(map2.get(key));
                result.add(true);
            }else {
                System.out.println("테스트 실패 들어왔다");
                result.add(false);
            }
        }
        
        // 비교값을 Boolean 배열에 넣고 false 가 있는지 비교 있으면 검사 불합격 
        for (int i = 0 ; i < result.size() ; i++){
            if (!result.get(i)){
                return false;
            }
        }
        return true;
    }

}
