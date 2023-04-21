package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new Product (p.id,p.name, p.measure, p.pr_type_id, prt.name, m.name) FROM Product p join ProductType prt on p.pr_type_id = prt.id join Measure m on m.id = prt.measure_id")
    List<Product> fetchAllProducts();

    @Query("SELECT new Product (p.id, p.name, p.pr_type_id, m.name, pt.name) FROM ProductType pt inner join Product p on p.pr_type_id = pt.id inner join Measure m on  m.id = pt.measure_id where p.id = :id")
    Product fetchProductWithTypeById(int id);

    @Query("SELECT new Product (p.id, p.name, p.pr_type_id, m.name, pt.name) FROM ProductType pt inner join Product p on p.pr_type_id = pt.id inner join Measure m on  m.id = pt.measure_id ")
    List<Product> fetchAllProductsWithType();
}
