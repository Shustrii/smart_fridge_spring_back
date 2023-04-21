package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.Measure;
import com.szub.smartfridgefullstack.model.ProductToRecipe;
import com.szub.smartfridgefullstack.model.Recipe;
import com.szub.smartfridgefullstack.repository.ProductToRecipeRepository;
import com.szub.smartfridgefullstack.repository.RecipeRepository;
import com.szub.smartfridgefullstack.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fridge/v1")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ProductToRecipeRepository productToRecipeRepository;

    //рецепты

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipe(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/ready_recipes")
    public List<Recipe> getAllReadyRecipe(){
        return recipeRepository.fetchReadyRecipes();
    }

    @GetMapping("/not_in_recipe/{id}")
    public ResponseEntity<List<ProductToRecipe>> getPrNotInRecipe(@PathVariable int id){
        List<ProductToRecipe> list = recipeService.getPrNotInRecipe(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id){
        Recipe recipe = recipeRepository.findById(id).get();
        //System.out.println(">>> getRecipeById " + recipe);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/recipe")
    public Recipe addNewRecipe(@RequestBody Recipe recipe){
        System.out.println("======>>>"+ recipe);
        System.out.println("+++++ addNewProduct");
        return recipeRepository.save(recipe);
    }

    @PutMapping("/recipe")
    public Recipe updateRecipe(@RequestBody Recipe recipe){
        System.out.println("======> product_update" + recipe);
        return recipeRepository.save(recipe);
    }

    @DeleteMapping("/recipe")
    public void deleteRecipe(@RequestBody Recipe recipe){
        System.out.println("=====>>>" + recipe);
        recipeRepository.delete(recipe);
    }

    //продукты в рецептах
    @GetMapping("/products_in_recipe/{id}")
    public ResponseEntity<List<ProductToRecipe>> getProductsToRecipeById(@PathVariable String id){
        System.out.println("++ getProductsToRecipeById");
        List<ProductToRecipe> list = recipeService.getProductToRecipeLeftJoin(Integer.parseInt(id));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/validate_recipe/{id}")
    public ResponseEntity<List<ProductToRecipe>> getPrNotEnoughInRec(@PathVariable int id){
        List<ProductToRecipe> list = recipeService.getProductsNotInRecipe(id);
        List<ProductToRecipe> list2 = recipeService.getPrNotEnoughInRecipe(id);
        list.addAll(list2);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/product_in_recipe")
    public ResponseEntity<ProductToRecipe> getProductInRecipeById(@PathVariable int id){
        ProductToRecipe list = recipeService.getProductInRecipeById(id);
        return  ResponseEntity.ok(list);
    }

    @PostMapping("/product_in_recipe")
    public ProductToRecipe saveProducts(@RequestBody ProductToRecipe productToRecipe){
        System.out.println(" ++saveProducts: "+productToRecipe);
        return productToRecipeRepository.save(productToRecipe);
    }

    @PutMapping("/product_in_recipe")
    public ProductToRecipe updateProductToRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("======> product_update" + productToRecipe);
        return productToRecipeRepository.save(productToRecipe);
    }

    @DeleteMapping("/product_in_recipe")
    public void deleteProductFromRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("=====>>>> delete_product_from_fridge >>>" + productToRecipe);
        System.out.println(">>> deleteProductFromFridge FR-ID:"+productToRecipe.getRecipes_id()+" PR-ID:"+productToRecipe.getProduct_id());
        productToRecipeRepository.delete(productToRecipe);
    }

    //меры по id
    @GetMapping("/measure/{id}")
    public ResponseEntity<List<Measure>> getMeasureByProduct(@PathVariable int id){
        List<Measure> list = recipeService.getMeasureByProductsId(id);
        return ResponseEntity.ok(list);
    }
}
