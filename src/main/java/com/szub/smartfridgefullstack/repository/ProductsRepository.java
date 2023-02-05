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

    //@Modifying
    //@Query("update Products p set p.name=:name, p.pr_type_id=:pr_type_id, p.measure=:measure where p.id=:id ")
    //int updateProduct(@Param("id") int id,@Param("name") String name, @Param("pr_type_id") int pr_type_id, @Param("measure") int measure);

    //@Modifying
    //@Query("delete from Products p where p.id =:id ")
    //int deleteProduct(@Param("id") int id);

    //@Query("SELECT new Product (p.id ,p.name, p.measure) FROM Product p where p.id = :id")
    //Product fetchProductById(int id);

    @Query("SELECT new Product (p.id, p.name, p.pr_type_id, m.name, pt.name) FROM ProductType pt inner join Product p on p.pr_type_id = pt.id inner join Measure m on  m.id = pt.measure_id where p.id = :id")
    Product fetchProductWithTypeById(int id);

    @Query("SELECT new Product (p.id, p.name, p.pr_type_id, m.name, pt.name) FROM ProductType pt inner join Product p on p.pr_type_id = pt.id inner join Measure m on  m.id = pt.measure_id ")
    List<Product> fetchAllProductsWithType();
}
