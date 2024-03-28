package com.team1.model.repository;

import com.team1.model.dto.ProductDto;
import com.team1.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    ProductEntity findBypname(String pname);
}
