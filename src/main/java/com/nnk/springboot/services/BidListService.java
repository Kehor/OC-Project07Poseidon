package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dto.BidListDto;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidListService {

    @Autowired
    private BidListRepository bidListRepository;

    public List<BidList> findAllBidList() {
        List<BidList> bidLists = bidListRepository.findAll();
        return bidLists;
    }

    public BidList findOneBidListById(int id) {
        BidList bidList = bidListRepository.findOneById(id);
        return bidList;
    }

    public void deleteOneBidListById(int id) {
        bidListRepository.delete(findOneBidListById(id));
    }

    public BidList saveBidList(BidList bidList) {
        bidList = bidListRepository.save(bidList);
        return bidList;
    }

    public BidList updateBidList(BidList bidList) {
        bidListRepository.updateBidList(bidList.getBidListId(), bidList.getAccount(), bidList.getType(), bidList.getBidQuantity());
        return bidList;
    }

    public List<BidListDto> bidListToBidListDto(List<BidList> bidList) {
        List<BidListDto> bidListDto = new ArrayList<BidListDto>();
        for (BidList bid: bidList) {
            BidListDto bidDto = new BidListDto(bid.getBidListId(), bid.getAccount(), bid.getType(), bid.getBid());
            bidListDto.add(bidDto);
        }
        return bidListDto;
    }


    public BidListDto oneBidListToBidListDtoById(int id) {
        BidList bidList = bidListRepository.findOneById(id);
        BidListDto bid = new BidListDto(bidList.getBidListId(),bidList.getAccount(),bidList.getType(),bidList.getBid());
        return bid;
    }
}
