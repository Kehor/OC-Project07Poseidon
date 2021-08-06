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
    /**
     *
     * @return all bidLists in a List<BidList>
     */
    public List<BidList> findAllBidList() {
        List<BidList> bidLists = bidListRepository.findAll();
        return bidLists;
    }
    /**
     *
     * @param id int
     * @return BidList
     */
    public BidList findOneBidListById(int id) {
        BidList bidList = bidListRepository.findOneById(id);
        return bidList;
    }
    /**
     * delete a bidList by its id
     * @param id int
     */
    public void deleteOneBidListById(int id) {
        bidListRepository.delete(findOneBidListById(id));
    }
    /**
     * save a bidList
     * @param bidList BidList
     * @return BidList
     */
    public BidList saveBidList(BidList bidList) {
        bidList = bidListRepository.save(bidList);
        return bidList;
    }

    /**
     * update a bidList
     * @param bidList BidList
     * @return BidList
     */
    public BidList updateBidList(BidList bidList) {
        bidListRepository.updateBidList(bidList.getBidListId(), bidList.getAccount(), bidList.getType(), bidList.getBidQuantity());
        return bidList;
    }

    /**
     * transform a List<BidList> into a List<BidListDto>
     * @param bidList List<BidList>
     * @return List<BidListDto>
     */
    public List<BidListDto> bidListToBidListDto(List<BidList> bidList) {
        List<BidListDto> bidListDto = new ArrayList<BidListDto>();
        for (BidList bid: bidList) {
            BidListDto bidDto = new BidListDto(bid.getBidListId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
            bidListDto.add(bidDto);
        }
        return bidListDto;
    }

    /**
     * find by its id and transform a BidList into a BidListDto
     * @param id int
     * @return BidListDto
     */
    public BidListDto oneBidListToBidListDtoById(int id) {
        BidList bidList = bidListRepository.findOneById(id);
        BidListDto bid = new BidListDto(bidList.getBidListId(),bidList.getAccount(),bidList.getType(),bidList.getBidQuantity());
        return bid;
    }
}
