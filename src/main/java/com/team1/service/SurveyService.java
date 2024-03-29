package com.team1.service;

import com.team1.model.dto.ProductDto;
import com.team1.model.dto.RecipeDto;
import com.team1.model.dto.WorkPlanDto;
import com.team1.model.dto.survetDto.SurveyPlanInfoDto;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RecipeEntity;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.RawMaterialEntityRepository;
import com.team1.model.repository.RecipeEntityRepository;
import com.team1.model.repository.WorkPlanEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private WorkPlanEntityRepository workPlanEntityRepository;
    @Autowired
    private RecipeEntityRepository recipeEntityRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RawMaterialEntityRepository rawMaterialEntityRepository;

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

    // 1. WorkPlan 식별번호로 만들제품 파악
    // 2. 제품에 들어가는 원재료 를 파악
    // 3. 반환해야하는것 = 제품명 / 수량 / 원재료종류수량 / 각 원재료별 필요한수량(수량*원재료비율)
    public SurveyPlanInfoDto surveyClilckDo(int wno){
        // 1. 반환할 객체 만들어두기
        SurveyPlanInfoDto surveyPlanInfoDto = new SurveyPlanInfoDto();

        // 2. 반환할거에 값 넣기
            // 2-1. 식별번호에 해당하는 workPlanDto 찾아서 넣기
                // 해당 workPlanDto 호출
        WorkPlanEntity workPlanEntity = workPlanEntityRepository.findBywno(wno);
        WorkPlanDto workPlanDto = workPlanEntity.toDto(); // DTO로 변환
//        System.out.println("workPlanDto = " + workPlanDto);
        surveyPlanInfoDto.setWorkPlanDto(workPlanDto); // 추가

            // 2-2. workPlan 에 해당하는 제품 레시피 찾아서 넣기
        // 레시피 찾아오기
        Optional<RecipeEntity> optionalRecipeEntity = recipeEntityRepository.findById(workPlanDto.getPno());
        // 찾은 엔티티가 존재하지 않으면 실패
        if(!optionalRecipeEntity.isPresent())return null;
        RecipeDto recipeDto = optionalRecipeEntity.get().toDto();
        surveyPlanInfoDto.setRecipeDto(recipeDto);// 추가

        // 제품 DTO 찾아오기
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(workPlanDto.getPno());
        if(!optionalProductEntity.isPresent())return null;
        recipeDto.setProductDto(optionalProductEntity.get().toDto());

        // 원자재 DTO 찾아오기
//        List<RawMaterialEntity> rawMaterialEntityList = rawMaterialEntityRepository.findByPno(workPlanDto.getPno());
//        rawMaterialEntityList.forEach((e)->{
//            recipeDto.setRawMaterrialDto();
//        });
//        recipeDto.setRawMaterrialDto(rawMaterialEntityList.get().toDto());


        return surveyPlanInfoDto;
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