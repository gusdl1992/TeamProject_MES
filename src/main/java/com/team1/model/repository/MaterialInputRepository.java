package com.team1.model.repository;

import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface MaterialInputRepository extends JpaRepository<MaterialInputEntity,Integer> {
    @Query(value = "select * from materialinput m inner join surveyb sb on m.sno2 = sb.sno where m.sno2 = :sno" , nativeQuery = true)
    List<MaterialInputEntity> findBySno(int sno);

    @Query(value = "select * from materialinput m inner join surveyb sb on m.sno2 = sb.sno inner join rawmaterial as a on sb.rmno = a.rmno join product as p on p.pno = m.pno join workplan as w on m.wno2 = w.wno  where sno = :sno" , nativeQuery = true)
    List<Map<Object,Object>> findByHard(int sno);
}
