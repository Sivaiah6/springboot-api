package com.java.crud.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Member_Demo")
@ApiModel(description="All details about the Member Demo. ")
public class Member_Demo {
    @Id
    @GeneratedValue
    private int mbr_id;
    private String subscbr_id;
    private int mbr_ssn;

    @ApiModelProperty(notes="Date should be in the format dd-MM-yyyy")
    @Size(min=2, message="Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date mbr_dob;

    private Date mbr_dod;
    private String mbr_gender;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="MemberId")
    private ProAuth proAuth;
}
