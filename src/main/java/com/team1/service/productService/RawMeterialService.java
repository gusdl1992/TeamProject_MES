package com.team1.service.productService;

import com.team1.model.dto.RawMaterialLogDto;
import com.team1.model.dto.RawMaterrialDto;
import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RawMaterialLogEntity;
import com.team1.model.repository.RawMateriallogRepository;
import com.team1.model.repository.RawMeterailRepository;
import com.team1.model.repository.RecipeREpositorty;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
public class RawMeterialService {
    @Autowired
    RawMeterailRepository rawMeterailRepository;
    @Autowired
    RawMateriallogRepository rawMateriallogRepository;
    public boolean doPostRawMeterial(RawMaterrialDto rawMaterrialDto){
        RawMaterialEntity rawMaterialEntity = rawMeterailRepository.save(rawMaterrialDto.toEntity());

        if(rawMaterialEntity.getRmno() >= 1){
            return true;
        }
        return false;
    }

    public List<RawMaterrialDto> doFindRawMeterialList(){
        List<RawMaterrialDto> result = rawMeterailRepository.findAll().stream().map(RawMaterialEntity::toDto).collect(Collectors.toList());

        return result;
    }

    public boolean doPostRmLog(RawMaterialLogDto rawMaterialLogDto){
        RawMaterialEntity rawMaterrialEntity = rawMeterailRepository.findByRmname(rawMaterialLogDto.getRmname());
        RawMaterialLogEntity rawMaterialLogEntity =  rawMateriallogRepository.save(rawMaterialLogDto.toEntity());

        if(rawMaterialLogEntity.getRmlno() >= 1){
            rawMaterialLogEntity.setRawMaterialEntity(rawMaterrialEntity);
            return true;
        }

        return false;
    }

    public List<RawMaterialLogDto> doFindRmLog(int pno){
        List<RawMaterialLogEntity> result = rawMateriallogRepository.findByPnoSql(pno);

        return result.stream().map(RawMaterialLogEntity::toDto).collect(Collectors.toList());

    }
}
