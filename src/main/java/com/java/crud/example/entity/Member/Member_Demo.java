package com.java.crud.example.entity.Member;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Member_Demo")
@ApiModel(description = "All details about the Member Demo. ")
public class Member_Demo {
    @Id
    @GeneratedValue
    private int mbr_demo_id;

    private String subscbr_id;
    private Long mbr_ssn;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
   // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dob;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    //@Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_dod;

    private String mbr_gender;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
   // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date mbr_covr_st_dt;

    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
   // @Range(message = "Date should be in the format dd-MM-yyyy")
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
    private Long mbr_tel_ph;
    private String mbr_email;
    private String mbr_frst_nm;
    private String mbr_mi_nm;
    private String mbr_lst_nm;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MemberId")
    @ToString.Exclude
    private ProAuth proAuth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Member_Demo that = (Member_Demo) o;
        return mbr_demo_id != 0 && Objects.equals(mbr_demo_id, that.mbr_demo_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
