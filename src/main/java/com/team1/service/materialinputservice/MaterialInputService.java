package com.team1.service.materialinputservice;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.MemberDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.dto.SurveyDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.MemberRepository;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.SurveyRepository;
import com.team1.service.memberserivce.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialInputService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    MaterialInputRepository materialInputRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Transactional
    public boolean doInputPost(int sno){
        System.out.println("MaterialInputService.doInputPost");
        System.out.println("sno = " + sno);

        MemberDto loginDto = memberService.doLogininfo();
        if ( loginDto == null ) return false;

        // 1. 로그인된 회원 엔티티 찾기
        Optional< MemberEntity > optionalMemberEntity = memberRepository.findById( loginDto.getMno() );
        // 2. 찾은 엔티티가 존재하지 않으면
        if( !optionalMemberEntity.isPresent() ) return false;
        // 3. 엔티티 꺼내기
        MemberEntity memberEntity = optionalMemberEntity.get();

        Optional<SurveyEntity> optionalSurveyEntity = surveyRepository.findById( sno );


        if (!optionalSurveyEntity.isPresent()) return false;

        SurveyEntity surveyEntity = optionalSurveyEntity.get();
        System.out.println("surveyEntity = " + surveyEntity);
        System.out.println("optionalSurveyEntity = " + optionalSurveyEntity);
        ProductEntity optionalProductEntity = productRepository.findBySnoSQL( sno );
            // insert
        MaterialInputEntity saveMaterialInput
                = materialInputRepository.save( MaterialInputEntity.builder().build() );

        if(saveMaterialInput.getMipno() >= 1){
            saveMaterialInput.setSurveyEntity( surveyEntity );
            saveMaterialInput.setProductEntity( optionalProductEntity );
            saveMaterialInput.setInputmemberEntity( memberEntity );
        // 인풋넘버 넣는곳
            return true;
        }
        return false;
    }

    @Transactional
    public List<MaterialInputDto> doInputAllInfoGet(){
//        System.out.println("MaterialInputController.doInputInfoGet");
//        List<MaterialInputEntity> result = materialInputRepository.findAll();
//
//        System.out.println("result = " + result);
//        // Entity를 Dto로 변환한다
//        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();
//            // 1. 꺼내온 entity를 순회한다
//        for (int i = 0; i < result.size(); i++) {
//            // 2.하나씩 entity를 꺼낸다
//            MaterialInputEntity materialInputEntity = result.get(i);
//                result.get(i).getSurveyBEntity().getSbno();
//            System.out.println("방금막쓴sno = " + materialInputEntity);
//
//            // 3. 해당 entity를 dto로 변환한다
//            MaterialInputDto materialInputDto = materialInputEntity.toDto();
//            // 4. 변환된 dto를 리스트에 담는다
//            materialInputDtoList.add(materialInputDto);
//
//        }
        List<MaterialInputDto> result = materialInputRepository.findBySno(1).stream().map( (materialInputEntity) -> {
            return materialInputEntity.toDto();
        }).collect(Collectors.toList());

        for (MaterialInputDto materialInputDto : result) {
            System.out.println("dddddddd"+materialInputDto);
        }
        return result;
    }



    @Transactional
    public List<Map<Object,Object>> doInputInfoGet(int sno){
//        System.out.println("MaterialInputController.doInputInfoGet");
//        List<MaterialInputEntity> result = materialInputRepository.findAll();
//
//        System.out.println("result = " + result);
//        // Entity를 Dto로 변환한다
//        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();
//            // 1. 꺼내온 entity를 순회한다
//        for (int i = 0; i < result.size(); i++) {
//            // 2.하나씩 entity를 꺼낸다
//            MaterialInputEntity materialInputEntity = result.get(i);
//                result.get(i).getSurveyBEntity().getSbno();
//            System.out.println("방금막쓴sno = " + materialInputEntity);
//
//            // 3. 해당 entity를 dto로 변환한다
//            MaterialInputDto materialInputDto = materialInputEntity.toDto();
//            // 4. 변환된 dto를 리스트에 담는다
//            materialInputDtoList.add(materialInputDto);
//
//        }

        return materialInputRepository.findByHard(sno);
    }

    public List<Object> surveyDtoList(){

        List<Object> surveyDtoList = new ArrayList<>();

        List<SurveyEntity> surveyEntityList = surveyRepository.findAll();

        for (int i = 0; i < surveyEntityList.size() ; i++) {
            surveyDtoList.add( surveyEntityList.get(i).toDto() );
        }
        return surveyDtoList;
    }




}

//        Optional<MaterialInputEntity> test = materialInputRepository.findBySno(1);
//        Optional<MaterialInputEntity> test2 = materialInputRepository.findByHard(1);
//        System.out.println("테스트 : "+test);
//        System.out.println("테스트2"+test2);