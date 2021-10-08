package com.chamith.employeems.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BasicEmployee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //@NotNull(message="Code is required")
    @Size(min=8, max=8, message="Character count should be 8")
    private String code;

    @Size(min=0, max=255, message="Maximum character count is 255")
    private String callingname;

    @Size(min=0, max=255, message="Maximum character count is 255")
    private String fullname;

    private LocalDate dobirth;

    @NotNull(message="NIC is required")
    @Size(min=0, max=12, message="Maximum character count is 12")
    private String nic;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String address;

    @Size(min=10, max=10, message="Character count should be 10")
    private String mobile;


    private LocalDate dorecruite;

    @Lob
    private byte[] photo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;

    @ManyToOne(optional=false)
    private Gender gender;

    @ManyToOne(optional=false)
    private Civilstatus civilstatus;

    @ManyToOne(optional=false)
    private Designation designation;

    @ManyToOne(optional=false)
    private Employeestatus employeestatus;

    @ManyToOne(optional=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private User creator;

    @ManyToOne(optional=false)
    private Nametitle nametitle;

    @Size(min=0, max=255, message="Maximum character count is 255")
    private String email;

    @ManyToOne(optional=false)
    private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "basicEmployee_has_skill",
            joinColumns = @JoinColumn(name = "basicEmployee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skillList;


    public BasicEmployee(Integer id){
        this.id = id;
    }

    public BasicEmployee(Integer id, String code, String callingname, Nametitle nametitle){
        this.id = id;
        this.code = code;
        this.callingname = callingname;
        this.nametitle = nametitle;
    }

}