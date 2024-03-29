package com.szub.smartfridgefullstack.service;

import com.szub.smartfridgefullstack.model.Measure;
import com.szub.smartfridgefullstack.model.ProductToRecipe;
import com.szub.smartfridgefullstack.model.Recipe;
import com.szub.smartfridgefullstack.repository.ProductToRecipeRepository;
import com.szub.smartfridgefullstack.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeRepository recipeRepository;

    @Resource
    private ProductToRecipeRepository productToRecipeRepository;


    //рецепты
    public List<Recipe> getAllRecipes(){
        List<Recipe> list = recipeRepository.fetchAllRecipes();
        return list;
    }

//    public int updateRecipe(int id, String recipe ){
//        int update = recipeRepository.updateRecipe(id, recipe) ;
//        return update;
//    }

//    public int deleteRecipe(int id){
//        int list = recipeRepository.deleteRecipe(id);
//        return list;
//    }

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


//    public int updateProductToRecipe(int measureId, int productId, int quantity){
//        int update = productToRecipeRepository.updateProductToRecipe(measureId, productId, quantity);
//        return update;
//    }

//    public int deleteProductFromRecipe(int recipesId, int productId){
//        int list = productToRecipeRepository.deleteProductFromRecipe(recipesId, productId);
//        return list;
//    }

    public ProductToRecipe getProductInRecipeById(int pId, int rId){
        ProductToRecipe list = productToRecipeRepository.fetchProductById(pId, rId);
        return list;
    }

    //вынимание мер
    public List<Measure> getMeasureByProductsId(int id){
        List<Measure> list = productToRecipeRepository.fetchMeasureByProductId(id);
        return list;

    }

    public List<ProductToRecipe> getPrNotInRecipe(int id){
        List<ProductToRecipe> list = productToRecipeRepository.fetchProductsNotInRecipe(id);
        return list;
    }

    public List<ProductToRecipe> getProductsNotInRecipe(int id){
        List<ProductToRecipe> list = productToRecipeRepository.fetchPrNotInRecipe(id);
        return list;
    }

    public List<ProductToRecipe> getPrNotEnoughInRecipe(int id){
        List<ProductToRecipe> list = productToRecipeRepository.fetchPrNotEnoughInRecipe(id);
        return list;
    }
}
