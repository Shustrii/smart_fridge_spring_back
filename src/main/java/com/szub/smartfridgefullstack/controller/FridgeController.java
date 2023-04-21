package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.*;
import com.szub.smartfridgefullstack.repository.*;
import com.szub.smartfridgefullstack.service.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class    FridgeController {

    @Autowired
    private FridgeProductsRepository fridgeProductsRepository;

    @Autowired
    private FridgeService fridgeService;

    private int fridgeId = 1;

    @GetMapping("/fridge_products/{id}")
    public ResponseEntity<List<FridgeProduct>> getAllFromFridgeById(@PathVariable int id){
        //System.out.println("++ call -> getFridgeLeftJoin");
        // only one fridge is used -> check if id is 1
        //if(id != fridgeId) id = fridgeId;
        List<FridgeProduct> list = fridgeService.getFridgeLeftJoin(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/not_in_fridge")
    public ResponseEntity<List<FridgeProduct>> getNotInFridge() {
        // const fridge_id = 1 is used -> redo for several storages
        List<FridgeProduct> list = fridgeService.getProductsNotInFridge(fridgeId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fridge_product/{id}")
    public ResponseEntity<FridgeProduct> getProductById(@PathVariable int id){
        FridgeProduct fridgeProduct = fridgeProductsRepository.findById(id).get();
        return ResponseEntity.ok(fridgeProduct);
    }

    @PostMapping("/fridge_product")
    public FridgeProduct saveFridgeProduct(@RequestBody FridgeProduct fridgeProduct){
        System.out.println("++ saveFridgeProduct: " + fridgeProduct);
        return fridgeProductsRepository.save(fridgeProduct);
    }

    @PutMapping("/fridge_product")
    public FridgeProduct updateProduct(@RequestBody FridgeProduct fridgeProduct){
        System.out.println("=====>>>> product_quantity_update >>>" + fridgeProduct);
        System.out.println("=====>>>>" + fridgeProduct);
        return fridgeProductsRepository.save(fridgeProduct);
    }

    @DeleteMapping("/fridge_product")
    public void deleteProductFromFridge(@RequestBody FridgeProduct fridgeProduct){
        fridgeProductsRepository.delete(fridgeProduct);
    }
}
