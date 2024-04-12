package com.team1.controller;

import com.team1.model.dto.ProductLogDto;
import com.team1.service.ProductLogService;
import com.team1.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productlog")
public class ProductLogController {

    @Autowired
    private ProductLogService productLogService;

    @PostMapping("/post.do")
    public void productLogDtos( int pgcount, int pno){
        System.out.println("제품로그 컨트롤러");
        System.out.println("★★★pgcount = " + pgcount +"pno"+ pno);
        productLogService.productLogDtos(pgcount , pno);
    }

}
