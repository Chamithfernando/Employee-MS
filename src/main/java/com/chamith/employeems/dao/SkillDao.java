package com.chamith.employeems.dao;

import com.chamith.employeems.entity.Nametitle;
import com.chamith.employeems.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends JpaRepository<Skill, Integer> {
}
