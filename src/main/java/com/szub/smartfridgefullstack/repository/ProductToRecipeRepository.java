package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.*;
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

    @Query("SELECT new ProductToRecipe(ptr.id, ptr.product_id, ptr.recipes_id, ptr.measure_id,ptr.quantity, p.name, m.name) FROM ProductToRecipe ptr join Product p on p.id = ptr.product_id " +
            "join Measure m on ptr.measure_id = m.id where ptr.recipes_id = :id")
    List<ProductToRecipe> fetchAllProductsForRecipeById(int id);

    @Query("select new ProductToRecipe (p2r.id, pr.id, p2r.recipes_id, prm.id, p2r.quantity, pr.name, prm.name) " +
            "from Product pr " +
            "left join ProductType pt on pt.id = pr.pr_type_id " +
            "left join Measure prm on prm.id = pt.measure_id " +
            "left join ProductToRecipe p2r on pr.id = p2r.product_id " +
            "where p2r.recipes_id = :id " +
            "and pr.id not in (select f.product_id from FridgeProduct f where f.product_id = pr.id) "
            )
    List<ProductToRecipe> fetchPrNotInRecipe(int id);

    @Query("select new ProductToRecipe (p2r.id, pr.id, p2r.recipes_id, prm.id, ((p2r.quantity * p2rm.value)-(f.quantity * fm.value)), pr.name, prm.name) " +
            "from Product pr " +
            "left join ProductType pt on pt.id = pr.pr_type_id " +
            "left join Measure prm on prm.id = pt.measure_id " +
            "left join ProductToRecipe p2r on pr.id = p2r.product_id " +
            "left join Measure p2rm on p2rm.id = p2r.measure_id " +
            "left join FridgeProduct f on f.product_id = pr.id " +
            "left join Measure fm on fm.id = f.measure_id " +
            "where p2r.recipes_id = :id and (p2r.quantity * p2rm.value) > (f.quantity * fm.value) " +
            "order by 2")
    List<ProductToRecipe> fetchPrNotEnoughInRecipe(int id);

    @Query("SELECT new ProductToRecipe (ptr.id, ptr.recipes_id, ptr.product_id, p.name, ptr.quantity) FROM ProductToRecipe ptr inner join Product p on p.id = ptr.product_id where ptr.id = :id ")
    ProductToRecipe fetchProductById(int id);

    @Modifying
    @Query("SELECT new Measure (m.id, m.name , m.measure_id) from Product p join ProductType prt on p.pr_type_id = prt.id join Measure m on m.measure_id=prt.measure_id where p.id=:id")
    List<Measure> fetchMeasureByProductId(@Param("id") int id);

    @Query("select new ProductToRecipe(p.id, p.name, pt.measure_id) from Product p inner join ProductType pt on pt.id=p.pr_type_id WHERE p.id not in (select ptr.product_id from ProductToRecipe ptr where ptr.recipes_id=:id)")
    List<ProductToRecipe> fetchProductsNotInRecipe(int id);

}
