package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.FridgeProduct;
import com.szub.smartfridgefullstack.model.ProductToRecipe;
import com.szub.smartfridgefullstack.model.Products;
import com.szub.smartfridgefullstack.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ProductToRecipeRepository extends JpaRepository<ProductToRecipe, Long> {


    @Query("SELECT new ProductToRecipe (ptr.recipes_id, ptr.product_id, p.name, ptr.quantity) FROM Products p inner join ProductToRecipe ptr on p.id = ptr.product_id where ptr.recipes_id = :id")
    List<ProductToRecipe> fetchAllProductsForRecipeById(int id);


    @Modifying
    @Query("update ProductToRecipe ptr set ptr.quantity = :quantity , ptr.product_id =:product_id where ptr.recipes_id = :recipes_id ")
    int updateProductToRecipe(@Param("recipes_id") int recipesId, @Param("product_id") int productId, @Param("quantity") int quantity);


    @Modifying
    @Query("delete from ProductToRecipe ptr where ptr.recipes_id=:recipes_id and ptr.product_id=:product_id ")
    int deleteProductFromRecipe(@Param("recipes_id") int recipesId, @Param("product_id") int productId);

    @Query("SELECT new ProductToRecipe (ptr.product_id, p.name, ptr.quantity) FROM Products p inner join ProductToRecipe ptr on p.id = ptr.product_id where ptr.recipes_id = :id")
    ProductToRecipe fetchProductById(int id);



}
