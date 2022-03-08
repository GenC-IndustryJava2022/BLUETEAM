package com.cognizant.academy.blueteam.models;

import java.util.*;
import javax.persistence.*;

@Entity
public class Product implements Comparable<Product>{

	
@Id
private int productId;
private String name;
private double price;
private String image;
private String description;
private int categoryId;

public Product(int productId, String name, double price, String image, String description, int categoryId) {
	super();
	this.productId = productId;
	this.name = name;
	this.price = price;
	this.image = image;
	this.description = description;
	this.categoryId = categoryId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
@Override
public int compareTo(Product p) {
	return this.getName().compareTo(p.getName());
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", image=" + image
			+ ", description=" + description + ", categoryId=" + categoryId + "]";
}
}
