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
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lab_Data")
@ApiModel(description="All details about the Lab Data. ")
public class Lab_Data {
    public static Object set;
    @Id
    @GeneratedValue
    private int Id;
    private String labtest_ref_num ;
    private String lab_id ;
    private String lab_name ;
    private String mbr_id ;
    private String mbr_frst_nm ;
    private String mbr_mi_nm ;
    private String mbr_lst_nm ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dob ;
    private String mbr_gender ;
    private String visit_id ;
    private String visit_typ ;
    private String visit_subtyp ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date test_date ;
    private String test_id ;
    private String test_name ;
    private String loinc_code ;
    private String test_status ;
    private String test_result_cd ;
    private String test_result_name ;
    private BigDecimal result_numeric ;
    private BigDecimal ref_range_low ;
    private BigDecimal ref_range_high ;
    private String units ;
    private String result_typ ;
    private String alert_typ ;
    private String ref_prvd_id ;
    private int ref_prvd_npi ;
    private int ref_prvd_tin ;
    private String ref_prvd_frst_nm ;
    private String ref_prvd_lst_nm ;

}
