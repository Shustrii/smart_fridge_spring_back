package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.*;
import com.szub.smartfridgefullstack.repository.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FridgeService {

    @Resource
    private FridgeRepository fridgeRepository;

    @Resource
    private FridgeProductsRepository fridgeProductsRepository;

    @PersistenceContext
    private EntityManager em;

    public List<FridgeProduct> getFridgeLeftJoin(int id){
        System.out.println("+++ getFridgeLeftJoin");
        List<FridgeProduct> list = fridgeRepository.fetchAllProductsInFridgeById(id);
        System.out.println("+++ getFridgeLeftJoin -> list");
        list.forEach(System.out::println);
        return list;
    }

    public List<FridgeProduct> getProductsNotInFridge(int id){
        List<FridgeProduct> list = fridgeRepository.fetchProductsNotInFridge(id);
        return list;
    }

    //required?
    public FridgeProduct getProductsByFridgeId(int id){
        FridgeProduct list = fridgeProductsRepository.fetchAllProductsByFridgeId(id);
        return list;
    }

}
