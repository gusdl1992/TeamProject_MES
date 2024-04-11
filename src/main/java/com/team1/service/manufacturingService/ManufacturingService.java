package com.team1.service.manufacturingService;

import com.team1.model.dto.ManufacturingDto.ManufacturingDto;
import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.MemberDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.entity.*;
import com.team1.model.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturingService {//class start

    @Autowired HttpServletRequest request;
    @Autowired MaterialInputEntityRepository materialInputEntityRepository;
    @Autowired SurveyBRepository surveyBRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired ManufacturingEntityRepository manufacturingEntityRepository;
    @Autowired BulkLogRepository bulkLogRepository;
    @Autowired WorkPlanEntityRepository workPlanEntityRepository;

    //MaterialInput 정보 전부 가져오기
    public List<MaterialInputDto> materialInputDtoList(){
        // 반환할 배열
        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();

        // entity 불러오기
        List<MaterialInputEntity> materialInputEntityList = materialInputEntityRepository.findAll();
        for (int i = 0; i < materialInputEntityList.size(); i++) {
            // entity 객체화
            materialInputDtoList.add(materialInputEntityList.get(i).toDto());
        }

        return materialInputDtoList;
    }

    // MaterialInput 클릭했을때 반환받는거
    public MaterialInputDto MaterialInputClickDo(int mipno){

        Optional<MaterialInputEntity> materialInputEntity = materialInputEntityRepository.findById(mipno);
        System.out.println("materialInputEntity = " + materialInputEntity);
        if(!materialInputEntity.isPresent()){return null;};

        MaterialInputDto materialInputDto =materialInputEntity.get().toDto();

        System.out.println("materialInputDto = " + materialInputDto);
        return materialInputDto;
    }


    // survey 식별번호로 투입한 수량/내용 알아오기
    public List<SurveyBDto> surveyInfoDo(int sno){
        // 엔티티 찾아오기
        List<SurveyBEntity> surveyBEntity = surveyBRepository.findBySno(sno);
        if(surveyBEntity==null){return null;}

        // 엔티티 DTO로 변환시키기
        List<SurveyBDto> surveyBDtoList = new ArrayList<>();

        for (int i = 0; i < surveyBEntity.size(); i++) {
            surveyBDtoList.add(surveyBEntity.get(i).toDto());
        }

        return surveyBDtoList;
    }

    // 등록버튼을 눌렀을때
    // 1. 벌크테이블에 벌크가 등록되어야함
    // 2. 벌크로그테이블에 기록되어야함
    // 유효성 검사 해야하는부분
    // 반환 = 1 이상은 성공
    // -1 = 로그인 정보없음
    // -2 투입공정 내용을 찾을 수 없음
    // -3 값이 이미 등록되어있음
    @Transactional
    public int ManufacturingInsertDo(int mipno){

        // 이미등록되어있으면 취소
        Optional<ManufacturingEntity> manufacturingEntity = manufacturingEntityRepository.findByMipno(mipno);
        if(manufacturingEntity.isPresent()){return -3;}


        // 로그인한 회원정보를 가져온다
        Object object =request.getSession().getAttribute("logindto");
        if(object==null){return -1;} // 값없으면 실패 받환
        MemberDto memberDto = (MemberDto)object; // 형변환
        // 받아온 mno-> member 엔티티 객체 찾아오기
        Optional<MemberEntity> memberEntity = memberRepository.findById(memberDto.getMno());
        if(!memberEntity.isPresent())return -1; // 찾은값이 없으면 실패 반환

        // 투입공정 엔티티 찾아오기
        Optional<MaterialInputEntity> materialInputEntity = materialInputEntityRepository.findById(mipno);
        if (!materialInputEntity.isPresent())return -2;

        // 투입한 수량 찾아오기
            // 투입공정 엔티티의 sno 를 값으로 줌
        List<SurveyBEntity> surveyBEntityList = surveyBRepository.findBySno(materialInputEntity.get().getSurveyEntity().getSno());
        // 반복문 돌려서 전채 수량 합치기
        int count = 0;
        for (int i = 0; i < surveyBEntityList.size(); i++) {
            count += surveyBEntityList.get(i).getSbcount();
        }

        // Manufacturing 테이블 등록
        ManufacturingEntity saveManufacturingEntity = manufacturingEntityRepository.save(ManufacturingEntity.builder()
                        .materialInputEntity(materialInputEntity.get()) // 해당 투입공정 입력
                        .mfcount(count) // 벌크 수량
                        .mfstate(1)// 상태 변경
                        .inputmemberEntity(memberEntity.get()) // 등록자 회원정보 등록
                .build());


        // bulkLog 테이블 등록
        BulkLogEntity bulkLogEntity = bulkLogRepository.save(BulkLogEntity.builder()
                        .blcount(count)
                        .manufacturingEntity(saveManufacturingEntity)
                .build());
        
        // workplan 상태 수정
        WorkPlanEntity workPlanEntity = workPlanEntityRepository.findBywno(materialInputEntity.get().getWorkPlanEntity().getWno());
        workPlanEntity.setWstate(5);


        return saveManufacturingEntity.getMfno();
    }

    // 검사기능 =========================================
    public List<ManufacturingDto> manufacturingDtoListDO(){
        // 반환할 배열
        List<ManufacturingDto> manufacturingDtoList = new ArrayList<>();

        // entity 불러오기
        List<ManufacturingEntity> materialInputEntityList = manufacturingEntityRepository.findAll();
        for (int i = 0; i < materialInputEntityList.size(); i++) {
            // entity 객체화
            manufacturingDtoList.add(materialInputEntityList.get(i).toDto());
        }

        return manufacturingDtoList;
    }

    // 검사완료 버튼 클릭시 스테이터스 수정
    public int manufacturingStateUpdateDo(int mfno,int state){

        Optional<ManufacturingEntity> manufacturingEntity = manufacturingEntityRepository.findById(mfno);
        if (!manufacturingEntity.isPresent())return 0;

        manufacturingEntity.get().setMfstate(state);

        return manufacturingEntity.get().getMfno();

    }

}// class end
