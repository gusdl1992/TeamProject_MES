package com.team1.controller;

import com.team1.service.MaterialInputConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materialinput")
public class MaterialInputConfirmController {
    @Autowired
    private MaterialInputConfirmService materialInputConfirmService;

    @PutMapping("/confirm")
    public int putMaterialInputConfirm(){
        int mno = 1;
        return materialInputConfirmService.putMaterialInputConfirm(mno);
    }
}
