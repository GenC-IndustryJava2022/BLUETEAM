package com.cognizant.academy.blueteam.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.models.Category;
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
		//return productRepository.findAll().stream().sorted((x,y)->x.getName().compareTo(y.getName())).collect(Collectors.toList());
		//return productRepository.findAll().stream().sorted((x,y)->Double.compare(x.getPrice(),y.getPrice())).collect(Collectors.toList());
		return productRepository.findAll();
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findOne(int id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findAllByCategoryAndPriceRange(Category category, double min, double max){
		List<Product> all = productRepository.findAll();
		List<Product> returning=all.stream()
		.filter(x->x.getCategoryId()==category.getCategoryId())
		.filter(x->x.getPrice()>=min&&x.getPrice()<=max)
		.collect(Collectors.toList());
		return returning;
	}
}
