package com.team1.controller;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.service.MaterialInputConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/materialinput")
public class MaterialInputConfirmController {
    @Autowired
    private MaterialInputConfirmService materialInputConfirmService;

    @PutMapping("/confirm.do")
    public boolean putMaterialInputConfirm(){
        int mno = 1;
        int mipno = 1;
        int mipstate = 1;
        return materialInputConfirmService.putMaterialInputConfirm(mno , mipno , mipstate);
    }


    @GetMapping("/confirm/log.do")
    public List<MaterialInputDto> getMaterialInputConfirmLog(){
        System.out.println("material 정보" + materialInputConfirmService.getMaterialInputConfirmLog());
        return materialInputConfirmService.getMaterialInputConfirmLog();
    }
}
