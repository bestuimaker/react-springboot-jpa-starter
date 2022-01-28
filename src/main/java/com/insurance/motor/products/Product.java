package com.insurance.motor.products;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.insurance.motor.sales.SalesOrder;

@Entity(name = "Product")
@Table(name = "product", uniqueConstraints = {
		@UniqueConstraint(name = "product_id_unique", columnNames = "productName") })
public class Product {

	@Id
	@SequenceGenerator(name = "product_id_sequence", sequenceName = "product_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_sequence")
	public Long productID;
	public String productName;
	public int productQuantity;


    public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@ManyToOne
    @JoinColumn(
            name = "order_ID",
            referencedColumnName = "orderId",
            foreignKey = @ForeignKey(
            		name = "Ordered_product_fk"
            		)
    )
	public SalesOrder salesOrder;
	
	public Product() {
	}

	public Product(String productName, int productQuantity) {
		this.productName = productName;
		this.productQuantity = productQuantity;
	}

	public Long getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productQuantity="
				+ productQuantity + "]";
	}

}
