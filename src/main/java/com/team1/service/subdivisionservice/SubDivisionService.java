package com.team1.service.subdivisionservice;

import com.team1.model.dto.MemberDto;
import com.team1.model.dto.SubDivisionDto;
import com.team1.model.entity.ManufacturingEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.SubdivisionEntity;
import com.team1.model.repository.ManufacturingEntityRepository;
import com.team1.model.repository.MemberRepository;
import com.team1.model.repository.SubDivisionRepository;
import com.team1.service.memberserivce.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubDivisionService {
    @Autowired
    private ManufacturingEntityRepository manufacturingEntityRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;

    // 소분 보고서 작성
    @Transactional
    public boolean doSubDivisionInputPost(int mfno , int failcount , int successcount){
        // 멤버
        MemberDto loginDto = memberService.doLogininfo();
        if ( loginDto == null ) return false;

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById( loginDto.getMno() );

        if( !optionalMemberEntity.isPresent() ) return false;

        MemberEntity memberEntity = optionalMemberEntity.get();

        // 벌크
        Optional<ManufacturingEntity> optionalManufacturingEntity = manufacturingEntityRepository.findById(mfno);
        if (!optionalManufacturingEntity.isPresent()) return false;

        ManufacturingEntity manufacturingEntity = optionalManufacturingEntity.get();

        // insert
        SubdivisionEntity saveSubDivision = subDivisionRepository.save(SubdivisionEntity.builder().build());

        if(saveSubDivision.getSdno() >= 1){
            saveSubDivision.setManufacturingEntity(manufacturingEntity);
            saveSubDivision.setInputmemberEntity(memberEntity);
            saveSubDivision.setFailCount(failcount);
            saveSubDivision.setSuccessCount(successcount);

            return true;
        }

        return false;
    }

    // 소분 모두 출력
    @Transactional
    public List<SubDivisionDto> doSubDivisionAllinfoGet(){
        List<SubdivisionEntity> subdivisionEntityList = subDivisionRepository.findAll();
        List<SubDivisionDto> subDivisionDtoList = new ArrayList<>();
        subdivisionEntityList.forEach((subdivisioninfo)->{
            subDivisionDtoList.add(subdivisioninfo.toDto());
        });
        return subDivisionDtoList;
    }

    // 벌크 정보 출력
    @Transactional
    public List<Object> doManufacturingAllinfoGet(){
        List<Object> manufacturingList = new ArrayList<>();

        List<ManufacturingEntity> manufacturingEntityList = manufacturingEntityRepository.findAll();

        for(int i = 0; i < manufacturingEntityList.size(); i++){
            manufacturingList.add(manufacturingEntityList.get(i));
        }

        return manufacturingList;
    }
}
