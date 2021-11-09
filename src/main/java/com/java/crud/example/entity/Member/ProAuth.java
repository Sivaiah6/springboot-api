package com.java.crud.example.entity.Member;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Member")
@ApiModel(description="All details about the Member. ")
public class ProAuth {

    @Id
    @GeneratedValue
    private int Id;

    private String MemberId;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    @ApiModelProperty(value = "Demo Details is mandatory",required = true)
    @ToString.Exclude
    private Collection<Member_Demo> member_demo;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Member_Elig> member_eligs;

    @JsonManagedReference
    @OneToMany(mappedBy="proAuth", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Member_PCP> member_pcps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProAuth proAuth = (ProAuth) o;
        return Id != 0 && Objects.equals(Id, proAuth.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
