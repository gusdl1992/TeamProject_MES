package com.team1.controller.expirationController;


import com.team1.model.dto.ExpirationDTO;
import com.team1.service.expirationService.ExpirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expiration")
public class ExpirationController {

    @Autowired
    ExpirationService expirationService;

    @GetMapping("/list/get.do")
    public List<ExpirationDTO> Expirationfind(){
        return expirationService.Expirationfind();
    }
}
