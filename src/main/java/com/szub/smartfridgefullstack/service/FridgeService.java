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
        //List<Fridge> list = em.createQuery("SELECT new com.szub.smartfridgefullstack.model.Fridge(p.id, f.quantity, p.id as id_of_product) "+
        //                "FROM Products p INNER JOIN p.fridges f", Fridge.class).getResultList();
        System.out.println("+++ getFridgeLeftJoin -> list");
        list.forEach(System.out::println);
        return list;

    }


    public List<FridgeProduct> getProductsNotInFridge(int id){
        List<FridgeProduct> list = fridgeRepository.fetchProductsNotInFridge(id);
        return list;
    }

    public FridgeProduct getProductById(int id){
        FridgeProduct list = fridgeProductsRepository.fetchAllProductsById(id);
        return list;
    }


    public int updateProductCard(int fridgeId, int productId, int quantity ){
        int updatePr = fridgeProductsRepository.updateProductToFridge(fridgeId,productId,quantity);
        return updatePr;
    }

    public int deleteProductFromFr(int fridgeId, int productId){
        int list = fridgeProductsRepository.deleteProductFromFridge(fridgeId,productId);
        return list;
    }





}
