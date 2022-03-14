package com.cognizant.academy.blueteam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.blueteam.models.Product;
import com.cognizant.academy.blueteam.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public String toString() {
		return "ProductController [productService=" + productService + "]";
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		System.out.println("getting a whole bunch of data");
		return productService.findAll();
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		productService.save(product);
		return product;
	}
}
