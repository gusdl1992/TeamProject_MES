package com.team1.model.repository;

import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipeREpositorty extends JpaRepository<RecipeEntity,Integer> {


    List<RecipeEntity> findByRmno(int rmno); //원자재 이름으로 들어가는 제품들 가져오기

    List<RecipeEntity> findByPno(int pno); //제품이름으로 들어가는 원자재들 가져오기

}
