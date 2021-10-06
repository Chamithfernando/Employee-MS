package com.chamith.employeems.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "refreshtoken")
@Data
@NoArgsConstructor
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Instant doissued;

    @Column(nullable = false)
    private Instant expiryDate;



    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    private RefreshTokenstatus tokenstatus;


    public RefreshToken(Integer id) {
        this.id = id;
    }



}
