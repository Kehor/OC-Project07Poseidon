package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {

    @Query(value = "SELECT * FROM rulename WHERE id = ?1 LIMIT 1", nativeQuery = true)
    public RuleName findOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE rulename r set name =?2, description =?3, json =?4, template =?5, sql_str =?6, sql_part =?7 where r.id = ?1", nativeQuery = true)
    public void updateRuleName(Integer id, String name, String description, String json, String template, String sqlStr, String sqlPart);
}
