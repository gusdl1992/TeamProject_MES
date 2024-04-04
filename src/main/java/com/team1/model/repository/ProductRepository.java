package com.team1.model.repository;

import com.team1.model.dto.ProductDto;
import com.team1.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    ProductEntity findByPname(String pname);


    @Query(value = "select p.* from product p inner join materialinput mip on p.pno = mip.pno where sno2 = :sno" , nativeQuery = true)
    ProductEntity findBySnoSQL( int sno );

}
