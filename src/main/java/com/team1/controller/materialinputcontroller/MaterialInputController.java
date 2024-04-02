package com.team1.controller.materialinputcontroller;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.service.materialinputservice.MaterialInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/material")
public class MaterialInputController {

    @Autowired
    MaterialInputService materialInputService;

    @GetMapping("/input/get.do")
    public boolean doInputPost(@RequestParam int sno){
        System.out.println("MaterialInputController.doInputPost");
        System.out.println("sno = " + sno);

        return materialInputService.doInputPost(sno);
    }

    @GetMapping("/input/allinfo/get.do")
    public List<MaterialInputDto> doInputAllInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");

        return materialInputService.doInputAllInfoGet();
    }

    @GetMapping("/input/info/get.do")
    public List<Map<Object,Object>> doInputInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");

        return materialInputService.doInputInfoGet();
    }

}
