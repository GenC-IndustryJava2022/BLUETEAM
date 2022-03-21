package com.cognizant.academy.blueteam.models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private int categoryId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "HEADER_IMAGE")
	private String headerImage;

	public Category() {
	}

	public Category(int categoryId, String name, String headerImage) {
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

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
				+ ", headerImage=" + headerImage + "]";
	}

}
