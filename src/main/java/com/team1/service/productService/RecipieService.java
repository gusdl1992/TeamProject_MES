package com.team1.service.productService;

import com.team1.model.dto.RecipeDto;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RecipeEntity;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.RawMeterailRepository;
import com.team1.model.repository.RecipeREpositorty;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipieService {

    @Autowired
    RecipeREpositorty recipeREpositorty;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RawMeterailRepository rawMeterailRepository;

    public List<RecipeDto> findRecipieListAll(){
        List< RecipeEntity> result  = recipeREpositorty.findAll();
        return result.stream().map(RecipeEntity::toDto).collect(Collectors.toList());
    }
    public List<RecipeDto> findRecipieList(String pname){
        List< RecipeEntity> result  = recipeREpositorty.findByPnameSQL(pname);
//        List<RecipeDto> result2 = new ArrayList<>();
//        for (RecipeEntity recipeEntity : result) {
//            RecipeDto recipeDto = recipeEntity.toDto();
//            result2.add(recipeDto);
//        }

        return result.stream().map(RecipeEntity::toDto).collect(Collectors.toList());
    }
    @Transactional
    public boolean insertRecipielist(List<RecipeDto> recipeDtos){
        for (RecipeDto i : recipeDtos) {
            RecipeEntity result = i.toEntity();
            ProductEntity productEntity =  productRepository.findById(i.getPno()).get();
            RawMaterialEntity rawMaterialEntity =  rawMeterailRepository.findById(i.getRmno()).get();
            RecipeEntity result2 = recipeREpositorty.save(result);
            if (result2 != null){
                result2.setRawMaterialEntity(rawMaterialEntity);
                result2.setProductEntity(productEntity);
//                result2.setProductEntity(); 제품fk 설정하기
//                result2.setRawMaterialEntity(); 원자재fk 설정하기
            }
        }
        
        return false;
    }
}
