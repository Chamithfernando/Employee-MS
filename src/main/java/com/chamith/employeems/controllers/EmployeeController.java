package com.chamith.employeems.controllers;


import com.chamith.employeems.dao.EmployeeDao;
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
@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public List<Employee> getAll(){
        return  employeeDao.findAll();
    }

    @GetMapping("/{id}")
    public Employee getAll(@PathVariable Integer id){
        Optional<Employee> optionalEmployee = employeeDao.findById(id);
        if (optionalEmployee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found");

        return  optionalEmployee.get();
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        return  employeeDao.save(employee);
    }

    @PutMapping("/{id}")
    public Employee add(@PathVariable Integer id, @RequestBody Employee employee){
        if (!employeeDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found");
        }


        employee.setId(id);
        return employeeDao.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if (!employeeDao.existsById(id)){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Empoyee is not found");
        }
        employeeDao.deleteById(id);
    }

}
