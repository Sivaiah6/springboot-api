package com.java.crud.example.service;

import com.java.crud.example.entity.Claims.Claims;
import com.java.crud.example.entity.Data.Lab_Data;
import com.java.crud.example.repository.ClaimsRepository;
import com.java.crud.example.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository repository;
    public Lab_Data saveLabData(Lab_Data lab_data) {
        return repository.save(lab_data);
    }

    public List<Lab_Data> saveLabDatas(List<Lab_Data> lab_data) {
        return repository.saveAll(lab_data);
    }

    public List<Lab_Data> getLabData() {
        return repository.findAll();
    }

    public Lab_Data getLabDataById(int id) {
        return repository.findById(id).orElse(null);
    }

    /*public Lab_Data getLabDataByName(String name) {
        return repository.findByName(name);
    }*/

    public Lab_Data updateLabData(Lab_Data lab_data) {
        Lab_Data existing = repository.findById(lab_data.getId()).orElse(null);
        existing.setLab_name(lab_data.getLab_name());

        return repository.save(existing);
    }

    public String deleteLabData(int id) {
        repository.deleteById(id);
        return "Lab Data " +id+ " is removed !! ";
    }
}
