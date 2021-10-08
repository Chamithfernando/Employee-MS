package com.chamith.employeems.controllers;


import com.chamith.employeems.dao.GenderDao;
import com.chamith.employeems.entity.Gender;
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
@RequestMapping("/api/v1/genders")
public class GenderController {

    @Autowired
    private GenderDao genderDao;

    @GetMapping
    public List<Gender> getAll(){
        return  genderDao.findAll();
    }


}
