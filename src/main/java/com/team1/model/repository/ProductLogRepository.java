package com.team1.model.repository;

import com.team1.model.entity.PackagingEntity;
import com.team1.model.entity.ProductLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLogRepository extends JpaRepository<ProductLogEntity , Integer > {


}
