package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface TradeRepository extends JpaRepository<Trade, Integer> {

    @Query(value = "SELECT * FROM trade WHERE tradeId = ?1 LIMIT 1", nativeQuery = true)
    public Trade findOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE trade t set account =?2, type =?3 where t.tradeId = ?1", nativeQuery = true)
    public void updateTrade(Integer tradeId, String account, String type);
}
