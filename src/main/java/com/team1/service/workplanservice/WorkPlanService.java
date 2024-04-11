package com.team1.service.workplanservice;


import com.team1.model.dto.MemberDto;
import com.team1.model.dto.WorkPlanDto;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.WorkPlanEntity;
import com.team1.model.repository.MemberRepository;
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

    public boolean postWPWriteDo(WorkPlanDto workPlanDto){
        // 멤버
        MemberDto loginDto = memberService.doLogininfo();
        if ( loginDto == null ) return false;

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById( loginDto.getMno() );

        if( !optionalMemberEntity.isPresent() ) return false;

        if(optionalMemberEntity.get().getMno() != -1) return false;

        WorkPlanEntity workPlanEntity =

        MemberEntity memberEntity = optionalMemberEntity.get();
        return workPlanService.postWPWriteDo();
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
