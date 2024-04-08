package com.team1.model.repository;

import com.team1.model.entity.SubdivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDivisionRepository extends JpaRepository<SubdivisionEntity,Integer> {
}
