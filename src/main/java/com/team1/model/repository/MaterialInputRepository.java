package com.team1.model.repository;

import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialInputRepository extends JpaRepository<MaterialInputEntity,Integer> {
    @Query(value = "select * from materialinput m inner join surveyb sb on m.sno2 = sb.sno where m.sno2 = :sno" , nativeQuery = true)
    Optional<MaterialInputEntity> findBySno(int sno );
}
