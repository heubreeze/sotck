package com.sa.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sa.entity.Stock;
import com.sa.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Resource
	StockService stockService;

	@RequestMapping(value = { "/findStockById" }, method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Stock findStockById(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Stock stock = stockService.findStockById(Long.parseLong(idStr));
		return stock;
	}
}
