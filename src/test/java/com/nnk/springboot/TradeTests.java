package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private TradeService tradeService;

	@Test
	public void tradeTest() {
		Trade trade = new Trade("Trade Account", "Type");

		// Save
		trade = tradeService.saveTrade(trade);
		Assert.assertNotNull(trade.getTradeId());
		Assert.assertTrue(trade.getAccount().equals("Trade Account"));

		// Update
		trade.setAccount("Trade Account Update");
		trade = tradeService.updateTrade(trade);
		Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));

		// Find
		List<Trade> listResult = tradeService.findAllTrade();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = trade.getTradeId();
		tradeService.deleteOneTradeById(id);
		Optional<Trade> tradeList = tradeRepository.findById(id);
		Assert.assertFalse(tradeList.isPresent());
	}
}
