package com.team1.model.repository;

import com.team1.model.entity.MaterialInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialInputRepository extends JpaRepository<MaterialInputEntity,Integer> {

}
