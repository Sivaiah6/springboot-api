package com.java.crud.example.repository;

import com.java.crud.example.entity.Claims.Claims;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsRepository extends JpaRepository<Claims, Integer> {
   // Claims findByName(String name);
}
