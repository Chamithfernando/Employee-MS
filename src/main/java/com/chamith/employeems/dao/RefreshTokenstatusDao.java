package com.chamith.employeems.dao;

import com.chamith.employeems.entity.RefreshToken;
import com.chamith.employeems.entity.RefreshTokenstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenstatusDao extends JpaRepository<RefreshTokenstatus, Integer> {
}
