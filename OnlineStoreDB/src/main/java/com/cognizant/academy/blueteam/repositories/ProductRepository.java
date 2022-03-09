package com.cognizant.academy.blueteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.academy.blueteam.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
//	public void insert(Product P);
//	public void update(Product P);
//	public void delete(Product P);
}
