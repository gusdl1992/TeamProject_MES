package com.team1.controller.productcontroller;

import com.team1.model.dto.ProductDto;
import com.team1.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class Productcotroller {
    @Autowired private ProductService productService;

    //1.제품 등록
    @PostMapping("/post.do")
    public boolean uploadProduct(ProductDto productDto){
        System.out.println(productDto);
        return productService.uploadProduct(productDto);
    }

    @GetMapping("/get.do")
    public List<ProductDto> productDtoList(){
        return productService.productDtoList();
    }

}
