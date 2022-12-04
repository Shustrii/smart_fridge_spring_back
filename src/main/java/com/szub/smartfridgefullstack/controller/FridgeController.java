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

    private SessionFactory sessionFactory;

    @Autowired
    private FridgeRepository fridgeRepository;


    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private FridgeProductsRepository fridgeProductsRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ProductToRecipeRepository productToRecipeRepository;

    @Autowired
    private FridgeService fridgeService;


    //справочник продуктов
    @GetMapping("/all/products")
    public List<Products> getAllProducts(){
        return fridgeService.getAllProducts();
    }

    @GetMapping("/product_by_id/{id}")
    public ResponseEntity<Products> getProductByIdInList(@PathVariable Long id){
        //Products products = productsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not exist with id :"+id));
        Products products = productsRepository.fetchAllListProductsById(Math.toIntExact(id));
        System.out.println(">>> getProductByIdInList " + products);
        return ResponseEntity.ok(products);
    }



    @DeleteMapping("/delete_product")
    public int deleteProduct(@RequestBody Products products){
        System.out.println("=====>>>" + products);
        int list = fridgeService.deleteProduct(products.getId());
        return list;
    }

    //добавление нового продукта в журнал продуктов
    @PostMapping("/add/product")
    public Products addNewProduct(@RequestBody Products products){
        System.out.println("======>>>"+ products);
        System.out.println("+++++ addNewProduct");
        return productsRepository.save(products);
    }


    @PutMapping("/product_update/{id}")
    public int updateInProductList(@RequestBody Products products){
        System.out.println("======> product_update" + products);
        int update = fridgeService.updateProduct(products.getId(),products.getName(),products.getMeasure(),products.getCost());

        return update;
    }


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


    //рецепты

    @GetMapping("/all/recipes")
    public List<Recipe> getAllRecipe(){
        return fridgeService.getAllRecipes();
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
        int update = fridgeService.updateRecipe(recipe.getId(), recipe.getRecipe());
        return update;
    }

    @DeleteMapping("/delete_recipe")
    public int deleteRecipe(@RequestBody Recipe recipe){
        System.out.println("=====>>>" + recipe);
        int list = fridgeService.deleteRecipe(recipe.getId());
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
        List<ProductToRecipe> list = fridgeService.getProductToRecipeLeftJoin(Integer.parseInt(id));
        return ResponseEntity.ok(list);
    }

    @PutMapping("/product_in_recipe_update")
    public int updateProductToRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("======> product_update" + productToRecipe);
        int update = fridgeService.updateProductToRecipe(productToRecipe.getRecipes_id(),productToRecipe.getProduct_id(), productToRecipe.getQuantity());
        return update;
    }

    @DeleteMapping("/delete_product_from_recipe")
    public int deleteProductFromRecipe(@RequestBody ProductToRecipe productToRecipe){
        System.out.println("=====>>>> delete_product_from_fridge >>>" + productToRecipe);
        System.out.println(">>> deleteProductFromFridge FR-ID:"+productToRecipe.getRecipes_id()+" PR-ID:"+productToRecipe.getProduct_id());
        int list = fridgeService.deleteProductFromRecipe(productToRecipe.getRecipes_id(), productToRecipe.getProduct_id());
        return list;
    }

    @GetMapping("/product_in_recipe/{id}")
    public ResponseEntity<ProductToRecipe> getProductInRecipeById(@PathVariable Long id){
        ProductToRecipe list = fridgeService.getProductInRecipeById(Math.toIntExact(id));
        return  ResponseEntity.ok(list);
    }


}
