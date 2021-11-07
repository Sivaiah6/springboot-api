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
@Table(name = "Member_PCP")
@ApiModel(description = "All details about the Member PCP. ")
public class Member_PCP {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private int pcp_id ;
    private String subscbr_id ;
    private String mbr_frst_nm ;
    private String mbr_mi_nm ;
    private String mbr_lst_nm ;
    private String pcp_prvd_id ;
    private String pcp_prvd_nm ;
    private String pcp_npi ;
    private String pcp_tin ;
    private String pcp_prvd_spec ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date pcp_prvd_eff_dt ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
    @Size(min = 8, message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date pcp_prvd_eff_end_dt ;
    private String pcp_prvd_serv_st ;
    private int pcp_prvd_serv_zip ;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MemberId")
    private ProAuth proAuth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
