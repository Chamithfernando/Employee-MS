package com.chamith.employeems.controllers;


import com.chamith.employeems.dao.BasicEmployeeDao;
import com.chamith.employeems.dao.EmployeeDao;
import com.chamith.employeems.entity.BasicEmployee;
import com.chamith.employeems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@RequestMapping("/api/v1/BasicEmployee")
public class BasicEmployeeController {

    @Autowired
    private BasicEmployeeDao basicEmployeeDao;

    @GetMapping
    public List<BasicEmployee> getAll(){
        return  basicEmployeeDao.findAll();
    }

    @GetMapping("/{id}")
    public BasicEmployee getAll(@PathVariable Integer id){
        Optional<BasicEmployee> optionalEmployee = basicEmployeeDao.findById(id);
        if (optionalEmployee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," Level 1 Employee not found");

        return  optionalEmployee.get();
    }

    @PostMapping
    public BasicEmployee add(@RequestBody BasicEmployee basicEmployee){
        return  basicEmployeeDao.save(basicEmployee);
    }

    @PutMapping("/{id}")
    public BasicEmployee add(@PathVariable Integer id, @RequestBody BasicEmployee basicEmployee){
        if (!basicEmployeeDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Level 1 Employee not found");
        }


        basicEmployee.setId(id);
        return basicEmployeeDao.save(basicEmployee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if (!basicEmployeeDao.existsById(id)){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Level 1 Employee is not found");
        }
        basicEmployeeDao.deleteById(id);
    }

}
