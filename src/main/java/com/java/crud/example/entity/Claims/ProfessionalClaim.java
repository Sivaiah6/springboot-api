package com.java.crud.example.entity.Claims;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProfessionalClaim")
@ApiModel(description = "All details about the Professional Claim. ")
public class ProfessionalClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pro_claim_id;

    private String claim_num;
    private int claim_ln_num;
    private String claim_org_num;
    private String claim_type;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date claim_serv_from_dt;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date claim_serv_to_dt;
    private String claim_status;
    private String claim_org_status;
    private String mbr_id;
    private String mbr_frst_nm;
    private String mbr_mi_nm;
    private String mbr_lst_nm;
    private String mbr_dob;
    private String mbr_gender;
    private String pcp_prvd_id;
    private String pcp_prvd_nm;
    private int pcp_npi;
    private int pcp_tin;
    private String pcp_prvd_spec;
    private String pcp_prvd_serv_st;
    private int pcp_prvd_serv_zip;
    private String plan_id;
    private String plan_nm;
    private String plan_typ;
    private String lob_typ;
    private String lob;
    private String grp_num;
    private String subgrp_num;
    private String clas_id;
    private String serv_prvd_id;
    private String serv_prvd_frst_nm;
    private String serv_prvd_lst_nm;
    private int serv_prvd_tin;
    private int serv_prvd_npi;
    private String serv_prvd_county;
    private String serv_prvd_state;
    private int serv_prvd_zip;
    private String serv_prvd_spec;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date admit_dt;
    private String admit_typ;
    private String admit_src;
    private String place_of_service;
    private String type_of_service;
    private String prin_diag_cd;
    private String sec_diag_cd;
    private String proc_cd;
    private String proc_mod;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date proc_dt;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dischrg_dt;
    private String dischrg_status;
    private String dischrg_to;
    private int len_of_stay;
    private int unit;
    private String pre_auth;
    private String rev_cd;
    private String drg_cd;
    private String cap_ffs;
    private BigDecimal claim_amt;
    private BigDecimal copay_amt;
    private BigDecimal coinsu_amt;
    private BigDecimal ded_amt;
    private BigDecimal allow_amt;
    private BigDecimal paid_amt;
    private String bill_type;
    private String type_of_visit;
    private String in_out_patient;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date paid_date;
    private String pay_method;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "claimId")
    private Claims claims;

}
