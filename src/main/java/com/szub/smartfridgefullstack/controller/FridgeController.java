package com.szub.smartfridgefullstack.controller;


import com.szub.smartfridgefullstack.exeption.ResourceNotFoundException;
import com.szub.smartfridgefullstack.model.*;
import com.szub.smartfridgefullstack.repository.*;
import com.szub.smartfridgefullstack.service.FridgeService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class    FridgeController {

    @Autowired
    private FridgeRepository fridgeRepository;


    @Autowired
    private FridgeProductsRepository fridgeProductsRepository;

    @Autowired
    private FridgeService fridgeService;

    //холодильник
    @PostMapping("/all/products")
    public FridgeProduct postFridgeProducts(@RequestBody FridgeProduct request) {
        System.out.println("=====>>>>" + request);
        System.out.println("++ getFridgeLeftJoin");
        //return new ResponseEntity<List<Fridge>>(joinQueryService.getFridgeLeftJoin(), HttpStatus.OK);
        //return ResponseEntity.ok(request);
        return fridgeProductsRepository.save(request);
    }


    @GetMapping("/all/products/{id}")
    public ResponseEntity<List<FridgeProduct>> getAllFromFridgeById(@PathVariable String id){
        System.out.println("++ getFridgeLeftJoin");
        //return new ResponseEntity<List<Fridge>>(joinQueryService.getFridgeLeftJoin(), HttpStatus.OK);
        List<FridgeProduct> list = fridgeService.getFridgeLeftJoin(Integer.parseInt(id));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/not_in_fridge")
    public ResponseEntity<List<FridgeProduct>> getNotInFridge() {
        List<FridgeProduct> list = fridgeService.getProductsNotInFridge(1);
        return ResponseEntity.ok(list);
    }
    @PostMapping("/save/fridge")
    public Fridge saveFridge(@RequestBody Fridge fridge){
//        System.out.println("++ saveFridge");
//        sessionFactory.getCurrentSession().saveOrUpdate(fridge);
//        return fridge;
        return fridgeRepository.save(fridge);
    }

    @PutMapping("/product_quantity_update")
    public int updateProduct(@RequestBody FridgeProduct fridgeProduct){
        System.out.println("=====>>>> product_quantity_update >>>" + fridgeProduct);
        int update = fridgeService.updateProductCard(fridgeProduct.getFridge_id(), fridgeProduct.getProduct_id(), fridgeProduct.getQuantity());
        System.out.println("=====>>>>" + fridgeProduct);
        return update; //ResponseEntity.ok(update);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<FridgeProduct> getProductById(@PathVariable Long id){
        FridgeProduct list = fridgeService.getProductById(Math.toIntExact(id));
        return  ResponseEntity.ok(list);
    }


    @DeleteMapping("/delete_product_from_fridge")
    public int deleteProductFromFridge(@RequestBody FridgeProduct fridgeProduct){
        System.out.println("=====>>>> delete_product_from_fridge >>>" + fridgeProduct);
        System.out.println(">>> deleteProductFromFridge FR-ID:"+fridgeProduct.getFridge_id()+" PR-ID:"+fridgeProduct.getProduct_id());
        int list = fridgeService.deleteProductFromFr(fridgeProduct.getFridge_id(), fridgeProduct.getProduct_id());
        return list;
    }


}
