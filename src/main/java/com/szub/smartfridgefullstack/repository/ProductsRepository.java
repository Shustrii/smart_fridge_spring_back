package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.FridgeProduct;
import com.szub.smartfridgefullstack.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query("SELECT p.name " +
            "FROM Products p LEFT JOIN p.fridges f")
    List<Products> fetchProductsLeftJoin();

    @Query("SELECT new Products(p.id,p.name, p.measure, p.cost) FROM Products p")
    List<Products> fetchAllProducts();

    @Modifying
    @Query("update Products p set p.name=:name, p.measure=:measure, p.cost = :cost where p.id=:id ")
    int updateProduct(@Param("id") int id,@Param("name") String name, @Param("measure") int measure, @Param("cost") int cost);

    @Modifying
    @Query("delete from Products p where p.id =:id ")
    int deleteProduct(@Param("id") int id);

    @Query("SELECT new Products (p.id ,p.name, p.measure, p.cost) FROM Products p where p.id = :id")
    Products fetchAllListProductsById(int id);
}
