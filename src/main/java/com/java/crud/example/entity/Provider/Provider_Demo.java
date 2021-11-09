package com.java.crud.example.entity.Provider;

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
@Table(name = "Provider_Demo")
@ApiModel(description = "All details about the Provider Demo. ")
public class Provider_Demo {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String prvd_id;
    private String prvd_faclty_nm;
    private String prvd_frst_nm;
    private String prvd_mi_nm;
    private String prvd_lst_nm;
    private Long prvd_ssn;
    private String prvd_tin;
    private String prvd_npi;
    private String prvd_serv_addr_ln_1;
    private String prvd_serv_addr_ln_2;
    private String prvd_serv_county;
    private String prvd_serv_city;
    private String prvd_serv_st;
    private int prvd_serv_zip;
    private Long prvd_serv_tel_ph;
    private String prvd_serv_email;
    private String prvd_bilg_addr_ln_1;
    private String prvd_bilg_addr_ln_2;
    private String prvd_bilg_county;
    private String prvd_bilg_city;
    private String prvd_bilg_st;
    private int prvd_bilg_zip;
    private Long prvd_bilg_tel_ph;
    private String prvd_bilg_email;
    private String prvd_spec_1;
    private String prvd_spec_2;
    private String prvd_spec_3;
    private String prvd_ntwk_id;
    private String prvd_ntwk_name;
    private String inntwk_outntwk;
    private String prvd_par_npar;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date prvd_eff_dt;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date prvd_end_dt;
    private String prvd_contr_typ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date prvd_ntwk_eff_dt;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date prvd_ntwk_end_dt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Provider_Demo that = (Provider_Demo) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
