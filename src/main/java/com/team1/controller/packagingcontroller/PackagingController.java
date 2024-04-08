package com.team1.controller.packagingcontroller;

import com.team1.model.entity.PackagingEntity;
import com.team1.service.packagingservice.PackagingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/packaging")
public class PackagingController {
    @Autowired
    private PackagingService packagingService;

    @GetMapping("/info/get.do")
    public List<PackagingEntity> doPackInfoGet(@RequestParam int pgno){
        System.out.println("PackagingController.doPackInfoGet");

        return packagingService.doPackInfoGet(pgno);
    }
}
