package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.Fridge;
import com.szub.smartfridgefullstack.model.FridgeProduct;
import com.szub.smartfridgefullstack.model.Products;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    @Query("SELECT new FridgeProduct(fp.fridge_id, fp.product_id, p.name, fp.quantity) FROM Products p inner join FridgeProduct fp on p.id = fp.product_id where fp.fridge_id = :id")
    List<FridgeProduct> fetchAllProductsInFridgeById(int id);

    @Query(value = "SELECT p FROM Products p WHERE p.id not in (SELECT f.product_id FROM FridgeProduct f)")
    List<Products> fetchProductsNotInFridge();

    //@SQLInsert(sql = "INSERT INTO fridge_products (fridge_id, product_id, quantity) VALUES (fp)")
    //void fetchSaveInFridge(FridgeProduct fp);
}
