package com.team1.model.repository;

import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.PackagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagingRepository extends JpaRepository<PackagingEntity , Integer > {
    @Query(value = "select packaging.* , pname , packagingcount , period from packaging inner join subdivision on packaging.sdno = subdivision.sdno inner join manufacturing on subdivision.mfno = manufacturing.mfno inner join materialinput on manufacturing.mipno = materialinput.mipno inner join product on materialinput.pno = product.pno where pgno=:pgno" , nativeQuery = true)
    List<PackagingEntity> findByPgno(int pgno);



}
