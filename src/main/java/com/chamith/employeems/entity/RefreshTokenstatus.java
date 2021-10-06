package com.chamith.employeems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "refreshTokenStatus")
@Data
@NoArgsConstructor
public class RefreshTokenstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "tokenstatus")
    private List<RefreshToken> tokenList;

    public RefreshTokenstatus(Integer id) {
        this.id = id;
    }
}
