package com.team1.service;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    public boolean putMaterialInputConfirm(int mno , int mipno , int mipstate){
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberInfo(mno);
        if(!optionalMemberEntity.isPresent()){
            return false;
        }
        System.out.println("optionalMemberEntity"+optionalMemberEntity);

        MaterialInputEntity materialInputEntity = materialInputRepository.findById(mipno).get();

        materialInputEntity.setCheckmembername(optionalMemberEntity.get());
        materialInputEntity.setMipstate(mipstate);

        System.out.println("materialInputEntity"+materialInputEntity);

        if (materialInputEntity.getCheckmembername() == null){
            return false;
        }
        return true;
    }

    @Transactional
    public List<MaterialInputDto> getMaterialInputConfirmLog(){
        List<MaterialInputEntity> materialInputMapList = materialInputRepository.findAll();
        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();
        materialInputMapList.forEach((matrialInfo)->{
            materialInputDtoList.add(matrialInfo.toDto());
        });

        Optional<MaterialInputEntity> test = materialInputRepository.findBySno(1);
        System.out.println("테스트"+test);

        return materialInputDtoList;
    }
}
//