package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.Measure;
import com.szub.smartfridgefullstack.model.ProductType;
import com.szub.smartfridgefullstack.repository.MeasureRepository;
import com.szub.smartfridgefullstack.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeasureService {
    @Resource
    private MeasureRepository measureRepository;

    public List<Measure> getMeasures(){
        //List<Measure> list = measureRepository.fetchAllMeasures();
        List<Measure> list = measureRepository.findAll();
        return list;
    }
}
