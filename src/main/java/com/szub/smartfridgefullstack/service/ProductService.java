package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.Products;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductsRepository productsRepository;


    public List<Products> getAllProducts(){
        List<Products> list = productsRepository.fetchAllProducts();
        return list;
    }

    public Products getListProductById(int id){
        Products products = productsRepository.fetchAllListProductsById(id);
        return products;
    }

    public int updateProduct(int id, String name, int measure, int cost ){
        int update = productsRepository.updateProduct(id,name,measure,cost);
        return update;
    }

    public int deleteProduct(int id){
        int list = productsRepository.deleteProduct(id);
        return list;
    }

    public List<Products> selectAllProductsWithType(){
        List<Products> list = productsRepository.fetchAllProductsWithType();
        return list;
    }


}
