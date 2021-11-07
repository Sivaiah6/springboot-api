package com.java.crud.example.controller;

import com.java.crud.example.entity.Provider.Provider_Demo;
import com.java.crud.example.service.ProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providerApi")
public class ProviderController {
    @Autowired
    private ProviderService service;

    public ProviderController(ProviderService providerService) {
    }

    @PostMapping("/addProvider")
    @ApiOperation(value = "Save a Provider")
    public Provider_Demo addProvider(@RequestBody Provider_Demo provider_demo) {
        return service.saveProvider(provider_demo);
    }

    @PostMapping("/addProviders")
    @ApiOperation(value = "Save multiple Providers",
            notes = "Also returns a link to retrieve all provider with rel - all-providers")
    public List<Provider_Demo> addProviders(@RequestBody List<Provider_Demo> provider_demos) {
        return service.saveProviders(provider_demos);
    }

    @GetMapping("/providers")
    @ApiOperation(value = "Find All Providers",
            notes = "Also returns a link to retrieve all provider with rel - all-Providers")
    public   List<Provider_Demo> findAllProviders() {

        return service.getProviders();

    }

    @GetMapping("/providerById/{id}")
    @ApiOperation(value = "Find Provider by id",
            notes = "Also returns a link to retrieve all provider with rel - all-provider")
    public Provider_Demo findProviderById(@PathVariable Long id) {
        return service.getProviderById(id);
    }

    /*@GetMapping("/provider/{name}")
    @ApiOperation(value = "Find provider by name",
            notes = "Also returns a link to retrieve all provider with rel - all-provider")
    public Provider_Demo findProviderByName(@PathVariable String name) {
        return service.getProviderByName(name);
    }
*/
    @PutMapping("/update")
    @ApiOperation(value = "Update a Provider Details")
    public Provider_Demo updateProvider(@RequestBody Provider_Demo provider_demo) {
        return service.updateProvider(provider_demo);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete Provider by id")
    public String deleteProvider(@RequestParam("id") Long id) {
        return service.deleteProvider(id);
    }
}
