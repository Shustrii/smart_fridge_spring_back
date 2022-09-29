package com.szub.smartfridgefullstack.controller;


import com.szub.smartfridgefullstack.exeption.ResourceNotFoundException;
import com.szub.smartfridgefullstack.model.Fridge;
import com.szub.smartfridgefullstack.model.FridgeProduct;
import com.szub.smartfridgefullstack.model.Products;
import com.szub.smartfridgefullstack.repository.FridgeProductsRepository;
import com.szub.smartfridgefullstack.repository.FridgeRepository;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
import com.szub.smartfridgefullstack.service.FridgeService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class FridgeController {

    private SessionFactory sessionFactory;

    @Autowired
    private FridgeRepository fridgeRepository;


    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private FridgeProductsRepository fridgeProductsRepository;

    @Autowired
    private FridgeService fridgeService;

    @GetMapping("/all/products")
    public List<Products> getAllProducts(){
        return fridgeService.getAllProducts();
    }

    @GetMapping("/all/products/{id}")
    public ResponseEntity<List<FridgeProduct>> getAllFromFridgeById(@PathVariable String id){
        System.out.println("++ getFridgeLeftJoin");
        //return new ResponseEntity<List<Fridge>>(joinQueryService.getFridgeLeftJoin(), HttpStatus.OK);
        List<FridgeProduct> list = fridgeService.getFridgeLeftJoin(Integer.parseInt(id));
        return ResponseEntity.ok(list);
    }

    @PostMapping("/all/products")
    public FridgeProduct postFridgeProducts(@RequestBody FridgeProduct request) {
        System.out.println("=====>>>>" + request);
        System.out.println("++ getFridgeLeftJoin");
        //return new ResponseEntity<List<Fridge>>(joinQueryService.getFridgeLeftJoin(), HttpStatus.OK);
        //return ResponseEntity.ok(request);
        return fridgeProductsRepository.save(request);
    }

    @GetMapping("/not_in_fridge")
    public ResponseEntity<List<Products>> getNotInFridge() {
        List<Products> list = fridgeService.getProductsNotInFridge();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/save/fridge")
    public Fridge saveFridge(@RequestBody Fridge fridge){
//        System.out.println("++ saveFridge");
//        sessionFactory.getCurrentSession().saveOrUpdate(fridge);
//        return fridge;
        return fridgeRepository.save(fridge);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<FridgeProduct>> getProductById(@PathVariable Long id){
//        FridgeProduct fridgeProduct = fridgeProductsRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException("Product not exist with id" + id));
//        return ResponseEntity.ok(fridgeProduct);
        List<FridgeProduct> list = fridgeService.getProductById(Math.toIntExact(id));
        return  ResponseEntity.ok(list);
    }


}
