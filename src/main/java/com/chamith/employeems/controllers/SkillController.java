package com.chamith.employeems.controllers;


import com.chamith.employeems.dao.SkillDao;
import com.chamith.employeems.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@RequestMapping("/api/v1/skills")
public class SkillController {

    @Autowired
    private SkillDao skillDao;

    @GetMapping
    public List<Skill> getAll(){
        return  skillDao.findAll();
    }


}
