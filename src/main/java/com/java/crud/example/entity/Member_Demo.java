package com.java.crud.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.crud.example.repository.ProAuthRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Member_Demo")
public class Member_Demo {
    @Id
    @GeneratedValue
    private int MBR_ID;
    private String SUBSCBR_ID;
    private int MBR_SSN;
    private Date MBR_DOB;
    private Date MBR_DOD;
    private String MBR_GENDER;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="MemberId")
    private ProAuth proAuth;
}
