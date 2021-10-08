package com.chamith.employeems.controllers;


import com.chamith.employeems.dao.NametitleDao;
import com.chamith.employeems.entity.Nametitle;
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
@RequestMapping("/api/v1/nametitles")
public class NametitleController {

    @Autowired
    private NametitleDao nametitleDao;

    @GetMapping
    public List<Nametitle> getAll(){
        return  nametitleDao.findAll();
    }


}
