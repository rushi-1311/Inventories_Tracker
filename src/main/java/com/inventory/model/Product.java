package com.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_Details")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "Prod_Id")
private Integer pid;
@Column (name = "Prod_Name")
private String pname;
@Column (name = "Prod_Price")
private Double price;
@Column (name = "Prod_Qty")
private Integer quantity;
public Product() {
	super();
}
public Product(Integer id, String name, Double price, Integer quantity) {
	super();
	this.pid = id;
	this.pname = name;
	this.price = price;
	this.quantity = quantity;
}
public Integer getId() {
	return pid;
}
public String getName() {
	return pname;
}
public Double getPrice() {
	return price;
}
public Integer getQuantity() {
	return quantity;
}
public void setId(Integer id) {
	this.pid = id;
}
public void setName(String name) {
	this.pname = name;
}
public void setPrice(Double price) {
	this.price = price;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Product [id=" + pid + ", name=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
}
}
