package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.ProductType;
import com.szub.smartfridgefullstack.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/all_product_types")
    public List<ProductType> getAllTypes(){
        return productTypeService.getTypes();
    }
}
