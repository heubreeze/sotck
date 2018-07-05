package com.sa.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sa.dao.StockDao;
import com.sa.entity.Stock;
import com.sa.service.StockService;


@Service(value = "stockService")
public class StockServiceImpl implements StockService {
	@Resource
	StockDao stockDao;
	
	@Override
	public Stock findStockById(Long id) {
		Stock stock = stockDao.findStockById(id);
		return stock;
	}



}
