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
@Table(name = "Member_PCP")
@ApiModel(description = "All details about the Member PCP. ")
public class Member_PCP {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String pcp_id ;
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
    //@Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date pcp_prvd_eff_dt ;
    @ApiModelProperty(notes = "Date should be in the format dd-MM-yyyy")
   // @Range(message = "Date should be in the format dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date pcp_prvd_eff_end_dt ;
    private String pcp_prvd_serv_st ;
    private int pcp_prvd_serv_zip ;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MemberId")
    @ToString.Exclude
    private ProAuth proAuth;

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
        Member_PCP that = (Member_PCP) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
