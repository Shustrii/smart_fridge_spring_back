package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.ProductToRecipe;
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
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT new Recipe (r.id, r.recipe) FROM Recipe r")
    List<Recipe> fetchAllRecipes();

//    @Modifying
//    @Query("update Recipe r set r.recipe= :recipe  where r.id=:id ")
//    int updateRecipe(@Param("id") int id, @Param("recipe") String recipe);

//    @Modifying
//    @Query("delete from Recipe r where r.id =:id ")
//    int deleteRecipe(@Param("id") int id);

    @Query("SELECT new Recipe (r.id, r.recipe) FROM Recipe r where r.id = :id")
    Recipe fetchAllRecipeById(int id);

    @Query("SELECT new Recipe (r.id, r.recipe) " +
            "FROM Recipe r " +
            "join ProductToRecipe pr on r.id = pr.recipes_id " +
            "join Measure prm on prm.id = pr.measure_id " +
            "join FridgeProduct fp on fp.product_id = pr.product_id " +
            "join Measure fpm on fpm.id = fp.measure_id " +
            "where (pr.quantity * prm.value2) <= (fp.quantity*fpm.value2) " +
            "group by r.id, r.recipe " +
            "having count (Recipe) = (select count(ProductToRecipe) from ProductToRecipe where recipes_id = r.id) ")
    List<Recipe> fetchReadyRecipes();
}
