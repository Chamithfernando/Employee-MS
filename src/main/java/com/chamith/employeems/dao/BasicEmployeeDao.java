package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicEmployeeDao extends JpaRepository<BasicEmployee, Integer> {
}
