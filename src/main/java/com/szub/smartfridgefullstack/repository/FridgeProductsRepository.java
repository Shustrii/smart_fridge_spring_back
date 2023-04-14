package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.FridgeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FridgeProductsRepository extends JpaRepository<FridgeProduct, Integer> {

    @Query("SELECT new FridgeProduct(fp.product_id, p.name) FROM Product p inner join FridgeProduct fp on p.id = fp.product_id where fp.fridge_id = :id")
    FridgeProduct fetchAllProductsById(int id);

//    @Modifying
//    @Query("update FridgeProduct fp set fp.quantity = :quantity where fp.fridge_id = :fridge_id and fp.product_id = :product_id")
//    int updateProductToFridge(@Param("fridge_id") int fridgeId, @Param("product_id") int productId, @Param("quantity") int quantity);

//    @Modifying
//    @Query("delete from FridgeProduct fp where fp.fridge_id=:fridge_id and fp.product_id=:product_id ")
//    int deleteProductFromFridge(@Param("fridge_id") int fridgeId, @Param("product_id") int productId);


}