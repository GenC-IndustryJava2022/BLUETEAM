package com.cognizant.academy.blueteam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.Product;
import com.cognizant.academy.blueteam.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public String toString() {
		return "ProductService [productRepository=" + productRepository + "]";
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product add(Product product) {
		return productRepository.save(product);
	}
}
