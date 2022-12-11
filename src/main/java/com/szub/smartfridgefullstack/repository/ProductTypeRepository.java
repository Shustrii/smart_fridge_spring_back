package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
