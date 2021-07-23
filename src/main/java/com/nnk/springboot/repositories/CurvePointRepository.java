package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

    @Query(value = "SELECT * FROM curvepoint WHERE id = ?1 LIMIT 1", nativeQuery = true)
    public CurvePoint findOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE curvepoint c set curveId =?2, term =?3, value =?4 where c.id = ?1", nativeQuery = true)
    public void updateCurvePoint(Integer id, Integer curveId, Double term, Double value);
}
