package com.team1.service.packagingservice;

import com.team1.model.dto.MemberDto;
import com.team1.model.dto.SubDivisionDto;
import com.team1.model.dto.packagingdto.PackagingDto;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.PackagingEntity;
import com.team1.model.entity.SubdivisionEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.repository.MemberRepository;
import com.team1.model.repository.PackagingRepository;
import com.team1.model.repository.SubDivisionRepository;
import com.team1.service.memberserivce.MemberService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PackagingService {
    @Autowired
    private PackagingRepository packagingRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;

    public List<Object> doPackInfoGet(int pgno) {

        List<Object> list = new ArrayList<>();

        List<PackagingEntity> packagingEntityList = packagingRepository.findByPgno(pgno);
        System.out.println("★packagingEntityList = " + packagingEntityList);


        packagingEntityList.forEach( (packaging) -> { list.add(packaging.toDto()); });

        return list;
    }

    public SubDivisionDto doSubdivisionInfoGet(int sdno){
        System.out.println("PackagingController.doSubdivisionInfoGet");
        System.out.println("sdno = " + sdno);
        SubDivisionDto subDivisionDto = subDivisionRepository.findById(sdno).get().toDto();
        return subDivisionDto;
    }

    @Transactional
    public boolean doMemberPost(int sdno){
        System.out.println("PackagingService.doMemberPost");

        MemberDto loginDto = memberService.doLogininfo();
        if ( loginDto == null ) return false;

        // 1. 로그인된 회원 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById( loginDto.getMno() );
        // 2. 찾은 엔티티가 존재하지 않으면
        if( !optionalMemberEntity.isPresent() ) return false;
        // 3. 엔티티 꺼내기
        MemberEntity memberEntity = optionalMemberEntity.get();

        SubdivisionEntity subdivisionEntity = subDivisionRepository.findById(sdno).get();


        PackagingEntity savePackaging = packagingRepository.save( PackagingEntity.builder().build() );

        if (savePackaging.getPgno() >= 1){
            savePackaging.setMemberEntity( memberEntity );
            savePackaging.setSubdivisionEntity( subdivisionEntity );

            return true;
        }

        return false;
    }

    public List<Object> subdivisionDtoList(){

        List<Object> subdivisionDtoList = new ArrayList<>();

        List<SubdivisionEntity> subdivisionEntityList = subDivisionRepository.findAll();

        for (int i = 0 ; i < subdivisionEntityList.size() ; i++){
            subdivisionDtoList.add( subdivisionEntityList.get(i).toDto() );
        }


        return subdivisionDtoList;
    }

}
