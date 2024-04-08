package com.team1.service.manufacturingService;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.SurveyBEntity;
import com.team1.model.repository.ManufacturingEntityRepository;
import com.team1.model.repository.MaterialInputEntityRepository;
import com.team1.model.repository.SurveyBRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturingService {//class start

    @Autowired HttpServletRequest request;
    @Autowired MaterialInputEntityRepository materialInputEntityRepository;
    @Autowired SurveyBRepository surveyBRepository;
    @Autowired ManufacturingEntityRepository manufacturingEntityRepository;

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

}// class end
