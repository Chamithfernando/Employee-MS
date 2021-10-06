package com.chamith.employeems.dao;

import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenDao extends JpaRepository<RefreshToken, Integer> {
}
