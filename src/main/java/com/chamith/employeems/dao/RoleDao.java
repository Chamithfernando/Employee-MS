package com.chamith.employeems.dao;


import com.chamith.employeems.entity.ERole;
import com.chamith.employeems.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
