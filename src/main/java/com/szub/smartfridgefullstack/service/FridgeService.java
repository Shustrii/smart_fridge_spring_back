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
    private ProductsRepository productsRepository;

    @Resource
    private FridgeProductsRepository fridgeProductsRepository;

    @Resource
    private RecipeRepository recipeRepository;

    @Resource
    private ProductToRecipeRepository productToRecipeRepository;

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

    public Products getListProductById(int id){
        Products products = productsRepository.fetchAllListProductsById(id);
        return products;
    }

    public int updateProductCard(int fridgeId, int productId, int quantity ){
        int updatePr = fridgeProductsRepository.updateProductToFridge(fridgeId,productId,quantity);
        return updatePr;
    }

    public int updateProduct(int id, String name, int measure, int cost ){
        int update = productsRepository.updateProduct(id,name,measure,cost);
        return update;
    }

    public int deleteProductFromFr(int fridgeId, int productId){
        int list = fridgeProductsRepository.deleteProductFromFridge(fridgeId,productId);
        return list;
    }

    public int deleteProduct(int id){
        int list = productsRepository.deleteProduct(id);
        return list;
    }


    //рецепты
    public List<Recipe> getAllRecipes(){
        List<Recipe> list = recipeRepository.fetchAllRecipes();
        return list;
    }

    public int updateRecipe(int id, String recipe ){
        int update = recipeRepository.updateRecipe(id, recipe) ;
        return update;
    }

    public int deleteRecipe(int id){
        int list = recipeRepository.deleteRecipe(id);
        return list;
    }

    public Recipe getRecipeById(int id){
        Recipe recipe = recipeRepository.fetchAllRecipeById(id);
        return recipe;
    }


    //продукты в рецептах


    public List<ProductToRecipe> getProductToRecipeLeftJoin(int id){
        System.out.println("+++ getFridgeLeftJoin");
        List<ProductToRecipe> list = productToRecipeRepository.fetchAllProductsForRecipeById(id);
        //List<Fridge> list = em.createQuery("SELECT new com.szub.smartfridgefullstack.model.Fridge(p.id, f.quantity, p.id as id_of_product) "+
        //                "FROM Products p INNER JOIN p.fridges f", Fridge.class).getResultList();
        System.out.println("+++ getFridgeLeftJoin -> list");
        list.forEach(System.out::println);
        return list;

    }


    public int updateProductToRecipe(int recipesId, int productId, int quantity){
        int update = productToRecipeRepository.updateProductToRecipe(recipesId, productId, quantity);
        return update;
    }

    public int deleteProductFromRecipe(int recipesId, int productId){
        int list = productToRecipeRepository.deleteProductFromRecipe(recipesId, productId);
        return list;
    }

    public ProductToRecipe getProductInRecipeById(int id){
        ProductToRecipe list = productToRecipeRepository.fetchProductById(id);
        return list;
    }


}
