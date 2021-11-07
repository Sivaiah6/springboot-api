package com.java.crud.example.repository;

import com.java.crud.example.entity.Data.Lab_Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Lab_Data, Integer> {
   // Lab_Data findByName(String name);
}
