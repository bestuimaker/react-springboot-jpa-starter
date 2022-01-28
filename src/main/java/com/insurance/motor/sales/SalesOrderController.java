package com.insurance.motor.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.motor.products.Product;
import com.insurance.motor.products.ProductRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SalesOrderController {
	private static final Logger log = LoggerFactory.getLogger(SalesOrderController.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SalesOrderService salesOrderService;
	
	@GetMapping("/sales")	
	public List<SalesOrder> GetAllSalesOrder() {
		return salesOrderService.GetAllSalesOrder();
	}

	@GetMapping("/products")	
	public List<Product> GetAllProducts() {
		return productRepository.findAll();
	}

@Bean
public CommandLineRunner demo(ProductRepository productRepository) {
	return (args) -> {
		productRepository.save(new Product("Milk Shake", 28));
		productRepository.save(new Product("Cup Cake", 18));
		productRepository.save(new Product("Maggie", 80));

		log.info("Products found with findAll():");
		log.info("-------------------------------");
		for (Product products : productRepository.findAll()) {
			log.info("loading------------------");
			log.info(products.toString());
		}
		log.info("-------------------------------");
		log.info("");		
	};
}

@Bean 
public CommandLineRunner feedSalesOrder(SalesOrderRepository salesOrderRepository) {
	return (args) ->{
		salesOrderRepository.save(new SalesOrder("Food Delivery", "20122022", "Bhagwati", 4563, 350));
		salesOrderRepository.save(new SalesOrder("Food Delivery", "20122022", "Bhagwati", 4563, 350));
		salesOrderRepository.save(new SalesOrder("Food Delivery", "20122022", "Bhagwati", 4563, 350));

		log.info("SalesOrders found with findAll():");
		log.info("-------------------------------");
		for (SalesOrder salesOrders : salesOrderRepository.findAll()) {
			log.info("loading------------------");
			log.info(salesOrders.toString());
		}
		log.info("-------------------------------");
		log.info("");		

	
	};
}
	
}
