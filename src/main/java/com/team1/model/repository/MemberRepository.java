package com.team1.model.repository;

import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
}
