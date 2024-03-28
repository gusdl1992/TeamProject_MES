package com.team1.controller;

import com.team1.model.dto.MaterialInputDto;
import com.team1.service.MaterialInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialInputController {

    @Autowired
    MaterialInputService materialInputService;

    @PostMapping("/input/post.do")
    public boolean doInputPost(MaterialInputDto materialInputDto){
        System.out.println("MaterialInputController.doInputPost");
        System.out.println("materialInputDto = " + materialInputDto);

        return materialInputService.doInputPost(materialInputDto);
    }

    @GetMapping("/input/info/get.do")
    public List<MaterialInputDto> doInputInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");

        return materialInputService.doInputInfoGet();
    }

}
