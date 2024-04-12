package com.team1.model.repository;

import com.team1.model.entity.ProductLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductlogRepository extends JpaRepository<ProductLogEntity , Integer> {


}
