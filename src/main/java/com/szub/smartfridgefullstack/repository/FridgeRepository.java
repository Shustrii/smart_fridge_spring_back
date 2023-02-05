package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.Fridge;
import com.szub.smartfridgefullstack.model.FridgeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Integer> {

    @Query("SELECT new FridgeProduct(fp.fridge_id, fp.product_id, p.name, fp.quantity, fp.measure_id, m.id, m.name) FROM Product p inner join FridgeProduct fp on p.id = fp.product_id inner join Measure m on m.id = fp.measure_id where fp.fridge_id = :id")
    List<FridgeProduct> fetchAllProductsInFridgeById(int id);

    //@Query(value = "SELECT p FROM Products p WHERE p.id not in (SELECT f.product_id FROM FridgeProduct f where f.fridge_id=:id) ")
    @Query(value = "SELECT new FridgeProduct(0, p.id, p.name, 0, pt.measure_id) FROM Product p inner join ProductType pt on pt.id = p.pr_type_id WHERE p.id not in (SELECT f.product_id FROM FridgeProduct f where f.fridge_id=:id) ")
    List<FridgeProduct> fetchProductsNotInFridge(int id);

    //@SQLInsert(sql = "INSERT INTO fridge_products (fridge_id, product_id, quantity) VALUES (fp)")
    //void fetchSaveInFridge(FridgeProduct fp);
}
