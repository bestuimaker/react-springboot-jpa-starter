package com.insurance.motor.sales;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.insurance.motor.products.Product;


@Entity(name = "SalesOrder")
@Table(name = "salesOrder", uniqueConstraints = {
		@UniqueConstraint(name = "sales_order_unique", columnNames = "orderID") })
public class SalesOrder {

	@Id
	@SequenceGenerator(
			name="sales_order_sequence",
			sequenceName = "sales_order_sequence",
			allocationSize = 1
			)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_order_sequence")
	public Long orderID;

	public String orderName;
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String orderDate;
	public String customerName;
	public int customerID;
	public int orderTotal;

    @OneToMany(
            mappedBy = "salesOrder",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
	public List<Product> products = new ArrayList<>();

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public SalesOrder(String orderName, String orderDate, String customerName, int customerID, int orderTotal) {
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerID = customerID;
		this.orderTotal = orderTotal;
	}
	public SalesOrder() {}

}
