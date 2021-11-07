package com.java.crud.example.controller;

import com.java.crud.example.entity.Claims.Claims;
import com.java.crud.example.service.ClaimsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claimsApi")
public class ClaimsController {
    @Autowired
    private ClaimsService service;

    public ClaimsController(ClaimsService claimsService) {
    }

    @PostMapping("/addClaim")
    @ApiOperation(value = "Save a Claim")
    public Claims addClaim(@RequestBody Claims claim) {
        return service.saveClaim(claim);
    }

    @PostMapping("/addClaims")
    @ApiOperation(value = "Save multiple Claims",
            notes = "Also returns a link to retrieve all claims with rel - all-claims")
    public List<Claims> addClaims(@RequestBody List<Claims> claims) {
        return service.saveClaims(claims);
    }

    @GetMapping("/claims")
    @ApiOperation(value = "Find All Claims",
            notes = "Also returns a link to retrieve all claims with rel - all-claims")
    public   List<Claims> findAllClaims() {

        return service.getClaims();

    }

    @GetMapping("/claimById/{id}")
    @ApiOperation(value = "Find claim by id",
            notes = "Also returns a link to retrieve all claim with rel - all-claims")
    public Claims findClaimById(@PathVariable int id) {
        return service.getClaimById(id);
    }

    @GetMapping("/claim/{name}")
    @ApiOperation(value = "Find claim by name",
            notes = "Also returns a link to retrieve all claim with rel - all-claims")
    public Claims findClaimByName(@PathVariable String name) {
        return service.getClaimsByName(name);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a Claim Details")
    public Claims updateClaim(@RequestBody Claims claims) {
        return service.updateClaims(claims);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete claim by id")
    public String deleteClaim(@RequestParam("id") int id) {
        return service.deleteClaim(id);
    }
}
