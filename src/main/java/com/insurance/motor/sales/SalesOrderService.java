package com.insurance.motor.sales;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.motor.products.Product;
import com.insurance.motor.products.ProductRepository;

@Service
public class SalesOrderService {

	private static final Logger log = LoggerFactory.getLogger(SalesOrderService.class);

	@Autowired
	ProductRepository productRepository;
	@Autowired 
	SalesOrderRepository salesOrderRepository;
	

	public List<SalesOrder> GetAllSalesOrder() {
		List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
				
		try {
			salesOrders = salesOrderRepository.findAll();
			salesOrders.forEach(a -> a.products = productRepository.findAll());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return salesOrders;	
	}

}
