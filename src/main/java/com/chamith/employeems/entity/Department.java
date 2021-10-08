/*
 * Generated By Spring Data JPA Entity Generator
 * @author Niroshan Mendis
 */

package com.chamith.employeems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="Name is required")
    @Size(min=0, max=100, message="Maximum character count is 100")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="department")
    private List<Employee> employeeList;



    public Department(Integer id){
        this.id = id;
    }


}
