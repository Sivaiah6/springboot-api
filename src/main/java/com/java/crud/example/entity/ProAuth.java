package com.java.crud.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Member")
@ApiModel(description="All details about the Member. ")
public class ProAuth {

    @Id
    @GeneratedValue
    private int MemberId;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    private Collection<Member_Demo> member_demo;

}
