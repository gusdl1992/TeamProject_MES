package com.team1.controller.packagingcontroller;

import com.team1.model.dto.SubDivisionDto;
import com.team1.model.dto.packagingdto.PackagingDto;
import com.team1.model.entity.PackagingEntity;
import com.team1.service.packagingservice.PackagingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/packaging")
public class PackagingController {
    @Autowired
    private PackagingService packagingService;

    @GetMapping("/info/get.do")
    public List<PackagingDto> doPackInfoGet(){

        return packagingService.doPackInfoGet();
    }

    @GetMapping("/subdivision/info/get.do")
    public SubDivisionDto doSubdivisionInfoGet(@RequestParam int sdno){



        return packagingService.doSubdivisionInfoGet(sdno);
    }

    // 반환 0 = 실패 / 1이상 = 성공 / -1 = 로그인정보가 없음  / -2 권한이 없는작업
    @PostMapping("/post.do")
    public int doMemberPost(int sdno , PackagingDto packagingDto){

        int pgbox = 1000;
        int pgcount = packagingDto.getPgcount();


        return packagingService.doMemberPost(sdno , pgbox , pgcount);
    }

    // sdno 정보 뽑아오기
    @GetMapping("/subdivision.do")
    public List<Object> subdivisionDtoList(){
        List<Object> result = packagingService.subdivisionDtoList();


        return result;
    }


}
