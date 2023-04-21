package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.Measure;
import com.szub.smartfridgefullstack.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    @GetMapping("/measures")
    public List<Measure> getAllMeasure(){
        return measureService.getMeasures();
    }
}
