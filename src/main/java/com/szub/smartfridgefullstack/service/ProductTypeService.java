package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.ProductType;
import com.szub.smartfridgefullstack.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeService {

    @Resource
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getTypes(){
        List<ProductType> list = productTypeRepository.findAll();
        return list;
    }
}
