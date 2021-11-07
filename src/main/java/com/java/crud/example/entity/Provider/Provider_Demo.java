package com.java.crud.example.entity.Provider;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Provider_Demo")
@ApiModel(description = "All details about the Provider Demo. ")
public class Provider_Demo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String prvd_id;
    private String prvd_faclty_nm;
    private String prvd_frst_nm;
    private String prvd_mi_nm;
    private String prvd_lst_nm;
    private int prvd_ssn;
    private String prvd_tin;
    private String prvd_npi;
    private String prvd_serv_addr_ln_1;
    private String prvd_serv_addr_ln_2;
    private String prvd_serv_county;
    private String prvd_serv_city;
    private String prvd_serv_st;
    private int prvd_serv_zip;
    private int prvd_serv_tel_ph;
    private String prvd_serv_email;
    private String prvd_bilg_addr_ln_1;
    private String prvd_bilg_addr_ln_2;
    private String prvd_bilg_county;
    private String prvd_bilg_city;
    private String prvd_bilg_st;
    private int prvd_bilg_zip;
    private int prvd_bilg_tel_ph;
    private String prvd_bilg_email;
    private String prvd_spec_1;
    private String prvd_spec_2;
    private String prvd_spec_3;
    private String prvd_ntwk_id;
    private String prvd_ntwk_name;
    private String inntwk_outntwk;
    private String prvd_par_npar;
    private Date prvd_eff_dt;
    private Date prvd_end_dt;
    private String prvd_contr_typ;
    private Date prvd_ntwk_eff_dt;
    private Date prvd_ntwk_end_dt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
