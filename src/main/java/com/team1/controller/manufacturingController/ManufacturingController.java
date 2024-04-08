package com.team1.controller.manufacturingController;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.service.manufacturingService.ManufacturingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/manufacturing") // 벌크 제조 컨트롤
@RestController
public class ManufacturingController {//class star

    @Autowired ManufacturingService manufacturingService;

    //MaterialInput 정보 전부 가져오기
    @GetMapping("/MaterialInput.do")
    public List<MaterialInputDto> materialInputDtoList(){

        return manufacturingService.materialInputDtoList();
    }

    // MaterialInput 클릭했을때 반환받는거
    // mipno
    @GetMapping("/MaterialInput/click.do")
    public MaterialInputDto MaterialInputClickDo(@RequestParam int mipno){

        System.out.println("mipno = " + mipno);

        return manufacturingService.MaterialInputClickDo(mipno);
    }

    // survey 식별번호로 투입한 수량/내용 알아오기
    @GetMapping("/surveyInfo.do")
    public List<SurveyBDto> surveyInfoDo(@RequestParam int sno){
        return manufacturingService.surveyInfoDo(sno);
    }

    // 등록버튼을 눌렀을때
    // 1. 벌크테이블에 벌크가 등록되어야함
    // 2. 벌크로그테이블에 기록되어야함
    // 유효성 검사 해야하는부분
    // 반환 = 1 이상은 성공
    @PostMapping("/insert.do")
    public int ManufacturingInsertDo(@RequestBody int mipno) {
        return manufacturingService.ManufacturingInsertDo();
    }


    // 검사기능


}//class end
