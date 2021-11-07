package com.java.crud.example.entity.Member;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @ApiModelProperty(value = "Demo Details is mandatory",required = true)
    private Collection<Member_Demo> member_demo;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    private Collection<Member_Elig> member_eligs;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    private Collection<Member_PCP> member_pcps;

}
