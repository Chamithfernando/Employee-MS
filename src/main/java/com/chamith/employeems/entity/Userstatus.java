package com.chamith.employeems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "userstaus")
@Data
@NoArgsConstructor
public class Userstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "userstatus")
    private List<User> userList;

    public Userstatus(Integer id) {
        this.id = id;
    }
}
