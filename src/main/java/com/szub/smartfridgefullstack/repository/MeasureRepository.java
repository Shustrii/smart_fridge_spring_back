package com.szub.smartfridgefullstack.repository;
import com.szub.smartfridgefullstack.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//to remove ?
public interface MeasureRepository extends JpaRepository<Measure, Long> {

}
