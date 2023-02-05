package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    @Modifying
    @Query("SELECT new ProductType  (pt.id, pt.name, pt.measure_id) FROM ProductType pt")
    List<ProductType> fetchAllTypes();
}
