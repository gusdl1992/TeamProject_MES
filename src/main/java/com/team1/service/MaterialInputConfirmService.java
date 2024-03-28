package com.team1.service;

import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInputConfirmService {
    @Autowired
    private MaterialInputRepository materialInputRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public int putMaterialInputConfirm(int mno){
        List<MemberEntity> memberEntity = memberRepository.findAll();


        for (MemberEntity entity : memberEntity) {
            if (entity.getMno() == mno ){
                String name = entity.getMname();

            }
        }
        return 0;
    }
}
