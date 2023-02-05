package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.Product;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import com.szub.smartfridgefullstack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductsRepository productsRepository;

    //справочник продуктов
    @GetMapping("/all/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/all/pr_type")
    public List<Product> getAllProdWithType(){
        return productService.selectAllProductsWithType();
    }

    @GetMapping("/product_by_id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        //Products products = productsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not exist with id :"+id));
        Product product = productsRepository.findById(id).get();
        //Optional<Product> product = productsRepository.findById(id);
        System.out.println(">>> getProductByIdInList " + product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete_product")
    public void deleteProduct(@RequestBody Product product){
        System.out.println("=====>>>" + product);
        //int list = productService.deleteProduct(products.getId());
        //return list;
        productsRepository.delete(product);
    }

    //добавление нового продукта в журнал продуктов
    @PostMapping("/add/product")
    public Product addProduct(@RequestBody Product product){
        System.out.println("======>>>"+ product);
        System.out.println("+++++ addNewProduct");
        return productsRepository.save(product);
    }

    @PutMapping("/product_update/{id}")
    public Product updateProduct(@RequestBody Product products){
        System.out.println("======> product_update: " + products);
        //int update = productService.updateProduct(products.getId(),products.getName(),products.getPr_type_id(), products.getMeasureName());
        //return update;
        Product product = productsRepository.save(products);
        return productsRepository.fetchProductWithTypeById(product.getId());
    }

}
