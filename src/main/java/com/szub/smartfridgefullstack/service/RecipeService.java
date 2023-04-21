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
        //List<Recipe> list = recipeRepository.fetchAllRecipes();
        List<Recipe> list = recipeRepository.findAll();
        return list;
    }

    public Recipe getRecipeById(int id){
        //Recipe recipe = recipeRepository.fetchAllRecipeById(id);
        Recipe recipe = recipeRepository.findById(id).get();
        return recipe;
    }

    //продукты в рецептах
    public List<ProductToRecipe> getProductToRecipeLeftJoin(int id){
        System.out.println("+++ getFridgeLeftJoin");
        List<ProductToRecipe> list = productToRecipeRepository.fetchAllProductsForRecipeById(id);
        System.out.println("+++ getFridgeLeftJoin -> list");
        list.forEach(System.out::println);
        return list;
    }

    public ProductToRecipe getProductInRecipeById(int id){
        ProductToRecipe list = productToRecipeRepository.fetchProductById(id);
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
