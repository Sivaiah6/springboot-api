package com.java.crud.example.repository;

import com.java.crud.example.entity.Provider.Provider_Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider_Demo,Long> {
    //Provider_Demo findByName(String name);
}
