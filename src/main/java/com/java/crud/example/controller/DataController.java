package com.java.crud.example.controller;

import com.java.crud.example.entity.Data.Lab_Data;
import com.java.crud.example.service.DataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labDataApi")
public class DataController {
    @Autowired
    private DataService service;

    public DataController(DataService dataService) {
    }

    @PostMapping("/addLabData")
    @ApiOperation(value = "Save a Lab Data")
    public Lab_Data addLabData(@RequestBody Lab_Data lab_data) {
        return service.saveLabData(lab_data);
    }

    @PostMapping("/addLabDatas")
    @ApiOperation(value = "Save multiple Lab Data",
            notes = "Also returns a link to retrieve all Lab Data with rel - all-data")
    public List<Lab_Data> addLabDatas(@RequestBody List<Lab_Data> lab_data) {
        return service.saveLabDatas(lab_data);
    }

    @GetMapping("/labData")
    @ApiOperation(value = "Find All Lab Data",
            notes = "Also returns a link to retrieve all Lab Data with rel - all-data")
    public   List<Lab_Data> findAllLabData() {

        return service.getLabData();

    }

    @GetMapping("/labDataById/{id}")
    @ApiOperation(value = "Find Lab Data by id",
            notes = "Also returns a link to retrieve all Lab Data with rel - all-data")
    public Lab_Data findLabDataById(@PathVariable int id) {
        return service.getLabDataById(id);
    }

   /* @GetMapping("/labData/{name}")
    @ApiOperation(value = "Find Lab data by name",
            notes = "Also returns a link to retrieve all Lab Data with rel - all-data")
    public Lab_Data findLabDataByName(@PathVariable String name) {
        return service.getLabDataByName(name);
    }*/

    @PutMapping("/updateLabData")
    @ApiOperation(value = "Update a Lab Data Details")
    public Lab_Data updateLabData(@RequestBody Lab_Data lab_data) {
        return service.updateLabData(lab_data);
    }

    @PostMapping("/deleteLabData")
    @ApiOperation(value = "Delete Lab Data by id")
    public String deleteLabData(@RequestParam("id") int id) {
        return service.deleteLabData(id);
    }
}
