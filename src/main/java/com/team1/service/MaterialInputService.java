package com.team1.service;

import com.team1.model.dto.MaterialInputDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInputService {

    public boolean doInputPost(MaterialInputDto materialInputDto){
        System.out.println("MaterialInputService.doInputPost");
        System.out.println("materialInputDto = " + materialInputDto);

        return false;
    }

    public List<MaterialInputDto> doInputInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");

        return null;
    }

}
