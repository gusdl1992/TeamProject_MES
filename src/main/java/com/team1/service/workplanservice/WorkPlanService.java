package com.team1.service.workplanservice;


import com.team1.model.dto.MemberDto;
import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.MemberRepository;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.SurveyRepository;
import com.team1.model.repository.WorkPlanEntityRepository;
import com.team1.service.memberserivce.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkPlanService {

    @Autowired
    WorkPlanEntityRepository workPlanEntityRepository;
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProductRepository productRepository;

    public boolean postWPWriteDo(WorkPlanDto workPlanDto){
        System.out.println("서비스workPlanDto = " + workPlanDto);
        // 멤버
        MemberDto loginDto = memberService.doLogininfo();
        if ( loginDto == null ) return false;

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById( loginDto.getMno() );

        if( !optionalMemberEntity.isPresent() ) return false;

        if(optionalMemberEntity.get().getPno() != -1) return false;

        ProductEntity productEntity = productRepository.findByPname(workPlanDto.getPname());

        WorkPlanEntity saveWorkPlan = WorkPlanEntity.builder()
                .wcount(workPlanDto.getWcount())
                .wendtime(workPlanDto.getWendtime()) // 이 부분 수정
                .productEntity(productEntity)
                .build();

        // 저장하기 전에 wno 값이 0보다 큰지 확인할 필요 없음
        WorkPlanEntity savedEntity = workPlanEntityRepository.save(saveWorkPlan);
        if (savedEntity != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<WorkPlanDto> findWPList(){
        return workPlanEntityRepository.findAll().stream().map(WorkPlanEntity::toDto).collect(Collectors.toList());
    }

    public int findSno(int wno){
        Integer result = surveyRepository.findSnoBywno(wno);
        if (result != null){
            return result.intValue();
        }
        return 0;
    }


}
