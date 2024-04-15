package com.team1.service;

import com.team1.controller.AlertSocekt;
import com.team1.model.dto.MaterialInputDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MaterialInputConfirmService {
    @Autowired
    private MaterialInputRepository materialInputRepository;
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    AlertSocekt alertSocekt;

    @Transactional
    public int putMaterialInputConfirm(int mno , int mipno , int mipstate){
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberInfo(mno);
        if(!optionalMemberEntity.isPresent()){
            return 0;
        }
        if (optionalMemberEntity.get().getPart() != 10 && optionalMemberEntity.get().getPart() != -1) {
            return -1;
        }
//        System.out.println("optionalMemberEntity"+optionalMemberEntity);//

        MaterialInputEntity materialInputEntity = materialInputRepository.findById(mipno).get();

        materialInputEntity.setCheckmemberEntity(optionalMemberEntity.get());
        materialInputEntity.setMipstate(mipstate);

        System.out.println("materialInputEntity"+materialInputEntity);

        if (materialInputEntity.getCheckmemberEntity() != null){
            // 작업 다 끝난후 검사 완료 메세지 소켓 전송
            try {
                alertSocekt.sendString(new TextMessage("투입 검사 완료!!"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return 1;
        }
        return 0;
    }

    @Transactional
    public List<MaterialInputDto> getMaterialInputConfirmLog(){
        List<MaterialInputEntity> materialInputMapList = materialInputRepository.findAll();
        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();
        materialInputMapList.forEach((matrialInfo)->{
            materialInputDtoList.add(matrialInfo.toDto());
        });



        return materialInputDtoList;
    }
}
//