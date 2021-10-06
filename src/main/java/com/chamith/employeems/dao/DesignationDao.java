package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationDao extends JpaRepository<Designation, Integer> {
}
