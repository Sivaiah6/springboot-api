package com.java.crud.example.entity.Claims;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Claims")
@ApiModel(description="All details about the Claims. ")
public class Claims {
    @Id
    @GeneratedValue
    private int claimId;

    @JsonManagedReference
    @OneToMany(mappedBy="claims", cascade = CascadeType.ALL)
    private Collection<PharmacyClaim> pharmacyClaims;

    @JsonManagedReference
    @OneToMany(mappedBy="claims", cascade = CascadeType.ALL)
    private Collection<FacilityClaim> facilityClaims;

    @JsonManagedReference
    @OneToMany(mappedBy="claims", cascade = CascadeType.ALL)
    private Collection<ProfessionalClaim> professionalClaims;
}
