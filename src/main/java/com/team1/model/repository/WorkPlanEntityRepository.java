package com.team1.model.repository;

import com.team1.model.entity.WorkPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlanEntityRepository extends JpaRepository<WorkPlanEntity , Integer> {
}
