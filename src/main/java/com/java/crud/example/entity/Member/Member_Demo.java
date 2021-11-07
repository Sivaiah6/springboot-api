package com.java.crud.example.entity.Member;

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
@ApiModel(description = "All details about the Member Demo. ")
public class Member_Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mbr_id;

    private String subscbr_id;
    private int mbr_ssn;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dob;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dod;

    private String mbr_gender;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_covr_st_dt;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_covr_end_dt;

    private String mbr_ethn;
    private String mbr_race;
    private String mbr_hm_addr_ln_1;
    private String mbr_hm_addr_ln_2;
    private String mbr_hm_county;
    private String mbr_hm_city;
    private String mbr_hm_st;
    private int mbr_hm_zip;
    private int mbr_tel_ph;
    private String mbr_email;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MemberId")
    private ProAuth proAuth;
}
