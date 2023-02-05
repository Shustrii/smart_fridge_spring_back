package com.szub.smartfridgefullstack.repository;
import com.szub.smartfridgefullstack.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasureRepository extends JpaRepository<Measure, Long> {

    @Modifying
    @Query("SELECT new Measure (m.id, m.name, m.measure_id, m.value) FROM Measure m")
    List<Measure> fetchAllMeasures();
}
