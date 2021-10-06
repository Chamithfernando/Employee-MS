package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.Nametitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NametitleDao extends JpaRepository<Nametitle, Integer> {
}
