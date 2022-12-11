package com.szub.smartfridgefullstack.controller;

import com.szub.smartfridgefullstack.model.ProductToRecipe;
import com.szub.smartfridgefullstack.model.Recipe;
import com.szub.smartfridgefullstack.repository.ProductToRecipeRepository;
import com.szub.smartfridgefullstack.repository.RecipeRepository;
import com.szub.smartfridgefullstack.service.FridgeService;
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

    @GetMapping("/all/recipes")
    public List<Recipe> getAllRecipe(){
        return recipeService.getAllRecipes();
    }


    @PostMapping("/add/recipe")
    public Recipe addNewRecipe(@RequestBody Recipe recipe){
        System.out.println("======>>>"+ recipe);
        System.out.println("+++++ addNewProduct");
        return recipeRepository.save(recipe);
    }


    @PutMapping("/recipe_update/{id}")
    public int updateRecipe(@RequestBody Recipe recipe){
        System.out.println("======> product_update" + recipe);
        int update = recipeService.updateRecipe(recipe.getId(), recipe.getRecipe());
        return update;
    }

    @DeleteMapping("/delete_recipe")
    public int deleteRecipe(@RequestBody Recipe recipe){
        System.out.println("=====>>>" + recipe);
        int list = recipeService.deleteRecipe(recipe.getId());
        return list;
    }

    @GetMapping("/recipe_by_id/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){
        //Products products = productsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not exist with id :"+id));
        Recipe recipe = recipeRepository.fetchAllRecipeById(Math.toIntExact(id));
        System.out.println(">>> getProductByIdInList " + recipe);
        return ResponseEntity.ok(recipe);
    }



    //продукты в рецептах

    //left join
    @GetMapping("/products_to_recipe/{id}")
    public ResponseEntity<List<ProductToRecipe>> getProductsToRecipeById(@PathVariable String id){
        System.out.println("++ getProductsToRecipeById");
        //return new ResponseEntity<List<Fridge>>(joinQueryService.getFridgeLeftJoin(), HttpStatus.OK);
        List<ProductToRecipe> list = recipeService.getProductToRecipeLeftJoin(Integer.parseInt(id));
        return ResponseEntity.ok(list);
    }

    @PutMapping("/product_in_recipe_update")
    public int updateProductToRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("======> product_update" + productToRecipe);
        int update = recipeService.updateProductToRecipe(productToRecipe.getRecipes_id(),productToRecipe.getProduct_id(), productToRecipe.getQuantity());
        return update;
    }

    @DeleteMapping("/delete_product_from_recipe")
    public int deleteProductFromRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("=====>>>> delete_product_from_fridge >>>" + productToRecipe);
        System.out.println(">>> deleteProductFromFridge FR-ID:"+productToRecipe.getRecipes_id()+" PR-ID:"+productToRecipe.getProduct_id());
        int list = recipeService.deleteProductFromRecipe(productToRecipe.getRecipes_id(), productToRecipe.getProduct_id());
        return list;
    }

    @GetMapping("/product_in_recipe/{id}")
    public ResponseEntity<ProductToRecipe> getProductInRecipeById(@PathVariable Long id){
        ProductToRecipe list = recipeService.getProductInRecipeById(Math.toIntExact(id));
        return  ResponseEntity.ok(list);
    }

}
