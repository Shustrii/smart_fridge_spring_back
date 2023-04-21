package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.Product;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductsRepository productsRepository;


    public List<Product> getAllProducts(){
        List<Product> list = productsRepository.fetchAllProducts();
        return list;
    }

    public List<Product> selectAllProductsWithType(){
        List<Product> list = productsRepository.fetchAllProductsWithType();
        return list;
    }


}
