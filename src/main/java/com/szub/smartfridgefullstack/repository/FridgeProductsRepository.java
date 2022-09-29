package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.FridgeProduct;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FridgeProductsRepository extends JpaRepository<FridgeProduct, Long> {

    @Query("SELECT new FridgeProduct(fp.product_id, p.name) FROM Products p inner join FridgeProduct fp on p.id = :id")
    List<FridgeProduct> fetchAllProductsById(int id);
}