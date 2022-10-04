package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.Fridge;
import com.szub.smartfridgefullstack.model.FridgeProduct;
import com.szub.smartfridgefullstack.model.Products;
import com.szub.smartfridgefullstack.repository.FridgeProductsRepository;
import com.szub.smartfridgefullstack.repository.FridgeRepository;
import com.szub.smartfridgefullstack.repository.ProductsRepository;
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
    private ProductsRepository productsRepository;

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


    public List<Products> getAllProducts(){
        List<Products> list = productsRepository.fetchAllProducts();
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

    public int updateProduct(int fridgeId, int productId, int quantity ){
        int updatePr = fridgeProductsRepository.updateProductToFridge(fridgeId,productId,quantity);
        return updatePr;
    }

    public int deleteProductFromFr(int fridgeId, int productId){
        int list = fridgeProductsRepository.deleteProductFromFridge(fridgeId,productId);
        return list;
    }

}
