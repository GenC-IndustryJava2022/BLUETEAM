package com.cognizant.academy.redteam;

import java.util.*;

public class Category{
	
private int categoryId;
private String name;
private String headerImage;
private ArrayList<Product> list;

public Category(int categoryId, String name, String headerImage){
	super();
	this.categoryId = categoryId;
	this.name = name;
	this.headerImage = headerImage;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getHeaderImage() {
	return headerImage;
}
public void setHeaderImage(String headerImage) {
	this.headerImage = headerImage;
}

public ArrayList<Product> getList() {
	return list;
}
public void setList(ArrayList<Product> list) {
	this.list = list;
}
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", name=" + name + ", headerImage=" + headerImage + "]";
}

}
