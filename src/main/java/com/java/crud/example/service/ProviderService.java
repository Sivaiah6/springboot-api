package com.java.crud.example.service;

import com.java.crud.example.entity.Provider.Provider_Demo;
import com.java.crud.example.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repository;
    public Provider_Demo saveProvider(Provider_Demo provider_demo) {
        return repository.save(provider_demo);
    }

    public List<Provider_Demo> saveProviders(List<Provider_Demo> provider_demos) {
        return repository.saveAll(provider_demos);
    }

    public List<Provider_Demo> getProviders() {
        return repository.findAll();
    }

    public Provider_Demo getProviderById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /*public Provider_Demo getProviderByName(String name) {
        return repository.findByName(name);
    }*/

    public Provider_Demo updateProvider(Provider_Demo provider_demo) {
        Provider_Demo existingProvider = repository.findById(provider_demo.getId()).orElse(null);
        existingProvider.setPrvd_frst_nm(provider_demo.getPrvd_frst_nm());
        return repository.save(existingProvider);
    }

    public String deleteProvider(Long id) {
        repository.deleteById(id);
        return "Provider " +id+ " is removed !! ";
    }
}
