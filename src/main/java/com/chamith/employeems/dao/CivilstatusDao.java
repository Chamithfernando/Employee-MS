package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.Civilstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilstatusDao extends JpaRepository<Civilstatus, Integer> {
}
