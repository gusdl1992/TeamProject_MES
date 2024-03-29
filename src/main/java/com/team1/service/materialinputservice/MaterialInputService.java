package com.team1.service.materialinputservice;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.dto.SurveyDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.SurveyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialInputService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    MaterialInputRepository materialInputRepository;
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public boolean doInputPost(int sno){
        System.out.println("MaterialInputService.doInputPost");
        System.out.println("sno = " + sno);


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

            return true;
        }
        return false;
    }

    public List<SurveyBDto> doInputInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");
//        List<SurveyBDto> result = ;
        return null;
    }

}
