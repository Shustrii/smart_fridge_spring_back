package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.Products;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import com.szub.smartfridgefullstack.service.FridgeService;
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

    //справочник продуктов
    @GetMapping("/all/products")
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/all/pr_type")
    public List<Products> getAllProdWithType(){
        return productService.selectAllProductsWithType();
    }

    @GetMapping("/product_by_id/{id}")
    public ResponseEntity<Products> getProductByIdInList(@PathVariable Long id){
        //Products products = productsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not exist with id :"+id));
        Products products = productsRepository.fetchAllListProductsById(Math.toIntExact(id));
        System.out.println(">>> getProductByIdInList " + products);
        return ResponseEntity.ok(products);
    }



    @DeleteMapping("/delete_product")
    public int deleteProduct(@RequestBody Products products){
        System.out.println("=====>>>" + products);
        int list = productService.deleteProduct(products.getId());
        return list;
    }

    //добавление нового продукта в журнал продуктов
    @PostMapping("/add/product")
    public Products addNewProduct(@RequestBody Products products){
        System.out.println("======>>>"+ products);
        System.out.println("+++++ addNewProduct");
        return productsRepository.save(products);
    }


    @PutMapping("/product_update/{id}")
    public int updateInProductList(@RequestBody Products products){
        System.out.println("======> product_update" + products);
        int update = productService.updateProduct(products.getId(),products.getName(),products.getMeasure(),products.getCost());

        return update;
    }

}
