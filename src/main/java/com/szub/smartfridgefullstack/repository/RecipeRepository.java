package com.szub.smartfridgefullstack.repository;

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
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT new Recipe (r.id, r.recipe) FROM Recipe r")
    List<Recipe> fetchAllRecipes();

    @Modifying
    @Query("update Recipe r set r.recipe= :recipe  where r.id=:id ")
    int updateRecipe(@Param("id") int id, @Param("recipe") String recipe);

    @Modifying
    @Query("delete from Recipe r where r.id =:id ")
    int deleteRecipe(@Param("id") int id);

    @Query("SELECT new Recipe (r.id, r.recipe) FROM Recipe r where r.id = :id")
    Recipe fetchAllRecipeById(int id);

}
