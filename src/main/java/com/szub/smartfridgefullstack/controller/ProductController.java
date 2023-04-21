package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.Product;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import com.szub.smartfridgefullstack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product_types")
    public List<Product> getAllProdWithType(){
        return productService.selectAllProductsWithType();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productsRepository.findById(id).get();
        System.out.println(">>> getProductByIdInList " + product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product){
        System.out.println("=====>>>" + product);
        productsRepository.delete(product);
    }

    //добавление нового продукта в журнал продуктов
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        System.out.println("======>>>"+ product);
        System.out.println("+++++ addNewProduct");
        return productsRepository.save(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product products){
        System.out.println("======> product_update: " + products);
        Product product = productsRepository.save(products);
        return productsRepository.fetchProductWithTypeById(product.getId());
    }

}
