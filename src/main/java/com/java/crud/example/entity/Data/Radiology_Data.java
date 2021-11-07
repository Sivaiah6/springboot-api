package com.java.crud.example.entity.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Radiology_Data")
@ApiModel(description="All details about the Radiology Data. ")
public class Radiology_Data {
    @javax.persistence.Id
    @GeneratedValue
    private int Id;
    private String rad_test_ref_id;
    private String rad_lab_id;
    private String rad_lab_name;
    private String mbr_id;
    private String mbr_frst_nm;
    private String mbr_mi_nm;
    private String mbr_lst_nm;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dob;
    private String mbr_gender;
    private String modu_id;
    private String descr_id;
    private String term;
    private String concept_id;
    private String lang;
    private String typ_id;
    private String access_map;
    private String typ;
    private String case_significance_id;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date rad_test_dt;

}
