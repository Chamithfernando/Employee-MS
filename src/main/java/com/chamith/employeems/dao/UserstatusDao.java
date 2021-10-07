package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.Userstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserstatusDao extends JpaRepository<Userstatus, Integer> {


}
