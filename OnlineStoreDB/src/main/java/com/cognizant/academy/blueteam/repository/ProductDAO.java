package com.cognizant.academy.blueteam.repository;

import com.cognizant.academy.blueteam.models.Product;

public interface ProductDAO {
	public void insert(Product P);
	public void update(Product P);
	public void delete(Product P);
}
