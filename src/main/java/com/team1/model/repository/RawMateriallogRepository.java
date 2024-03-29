package com.team1.model.repository;

import com.team1.model.entity.RawMaterialEntity;
import com.team1.model.entity.RawMaterialLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RawMateriallogRepository extends JpaRepository<RawMaterialLogEntity,Integer> {

    @Query(value = "select * from rawmateriallog where pno = :pno",nativeQuery = true)
    List<RawMaterialLogEntity> findByPnoSql(int pno);
}
