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
@Table(name = "Member_Elig")
@ApiModel(description = "All details about the Member Eligibility. ")
public class Member_Elig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mbr_elg_id;


    private String subscbr_id;
    private String mbr_frst_nm;
    private String mbr_mi_nm;
    private String mbr_lst_nm;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_elig_st_dt;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_elig_end_dt;
    private String subscbr_typ;
    private String prod_id;
    private String prod_nm;
    private String plan_id;
    private String plan_nm;
    private String plan_typ;
    private String lob_typ;
    private String lob;
    private String exchange;
    private String metal_typ;
    private String grp_num;
    private String subgrp_num;
    private String clas_id;
    private String grp_nm;
    private String subgrp_nm;
    private String clas_nm;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MemberId")
    private ProAuth proAuth;
}
