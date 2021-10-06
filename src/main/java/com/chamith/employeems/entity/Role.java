package com.chamith.employeems.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @JsonIgnore
    @ManyToMany
    private List<User> userList;

    @ManyToMany
    @JoinTable(
            name = "roleusecase",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "usecase_id")
    )
    private List<Usecase> usecaseList;


    public Role(ERole name) {
        this.name = name;
    }

    public Role(Integer id) {
        this.id = id;
    }
}
