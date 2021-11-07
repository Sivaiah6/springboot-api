package com.java.crud.example.service;

import com.java.crud.example.entity.Claims.Claims;
import com.java.crud.example.repository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClaimsService {
    @Autowired
    private ClaimsRepository repository;
    public Claims saveClaim(Claims claims) {
        return repository.save(claims);
    }

    public List<Claims> saveClaims(List<Claims> claims) {
        return repository.saveAll(claims);
    }

    public List<Claims> getClaims() {
        return repository.findAll();
    }

    public Claims getClaimById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Claims getClaimsByName(String name) {
        Claims claims = new
                Claims();
        return claims;
        //return repository.findByName(name);
    }

    public Claims updateClaims(Claims claims) {
        Claims existingClaims = repository.findById(claims.getClaimId()).orElse(null);
        existingClaims.setPharmacyClaims(claims.getPharmacyClaims());
        existingClaims.setFacilityClaims(claims.getFacilityClaims());
        existingClaims.setProfessionalClaims(claims.getProfessionalClaims());
        return repository.save(existingClaims);
    }

    public String deleteClaim(int id) {
        repository.deleteById(id);
        return "Claim " +id+ " is removed !! ";
    }
}
