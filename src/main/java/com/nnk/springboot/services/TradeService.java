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

    public List<Trade> findAllTrade() {
        List<Trade> trades = tradeRepository.findAll();
        return trades;
    }

    public Trade findOneTradeById(int id) {
        Trade trade = tradeRepository.findOneById(id);
        return trade;
    }

    public void deleteOneTradeById(int id) {
        tradeRepository.delete(findOneTradeById(id));
    }

    public Trade saveTrade(Trade trade) {
        trade = tradeRepository.save(trade);
        return trade;
    }

    public Trade updateTrade(Trade trade) {
        tradeRepository.updateTrade(trade.getTradeId(), trade.getAccount(), trade.getType());
        return trade;
    }

}
