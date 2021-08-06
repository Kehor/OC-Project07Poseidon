package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;
    /**
     *
     * @return all Trade in a List<Trade>
     */
    public List<Trade> findAllTrade() {
        List<Trade> trades = tradeRepository.findAll();
        return trades;
    }
    /**
     *
     * @param id int
     * @return Trade
     */
    public Trade findOneTradeById(int id) {
        Trade trade = tradeRepository.findOneById(id);
        return trade;
    }
    /**
     * delete a Trade by its id
     * @param id int
     */
    public void deleteOneTradeById(int id) {
        tradeRepository.delete(findOneTradeById(id));
    }
    /**
     * save a Trade
     * @param trade Trade
     * @return Trade
     */
    public Trade saveTrade(Trade trade) {
        trade = tradeRepository.save(trade);
        return trade;
    }
    /**
     * update a Trade
     * @param trade Trade
     * @return Trade
     */
    public Trade updateTrade(Trade trade) {
        tradeRepository.updateTrade(trade.getTradeId(), trade.getAccount(), trade.getType(),trade.getBuyQuantity(), trade.getSellQuantity());
        return trade;
    }

}
