package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer> {

    @Query(value = "SELECT * FROM bidlist WHERE bid_list_id = ?1 LIMIT 1", nativeQuery = true)
    public BidList findOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE bidlist b set account =?2, type =?3, bid_quantity =?4 where b.bid_list_id = ?1", nativeQuery = true)
    public void updateBidList(Integer BidListId, String account, String type, Double bidQuantity);
}
