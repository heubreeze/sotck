package com.sa.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sa.entity.Stock;

@Repository
public interface StockDao {
	
	Stock findStockById(@Param("id")Long id);
}	
