package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query("SELECT p.name " +
            "FROM Products p LEFT JOIN p.fridges f")
    List<Products> fetchProductsLeftJoin();

    @Query("SELECT new Products(p.name, p.measure, p.cost) FROM Products p")
    List<Products> fetchAllProducts();
}
