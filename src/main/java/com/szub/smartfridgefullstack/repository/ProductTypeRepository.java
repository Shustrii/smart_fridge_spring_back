package com.szub.smartfridgefullstack.repository;

import com.szub.smartfridgefullstack.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//to remove ?
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
