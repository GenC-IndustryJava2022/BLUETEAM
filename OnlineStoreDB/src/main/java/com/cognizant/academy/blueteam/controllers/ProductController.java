package com.cognizant.academy.blueteam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.blueteam.models.Cart;
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

	@CrossOrigin()
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		System.out.println("getting a whole bunch of data");
		return productService.findAll();
	}

	@CrossOrigin()
	@GetMapping("/find")
	public Optional<Product> getOneCart(@RequestParam int id) {
//		TODO: gracefully respond when wrong parameters are passed (or nonexistant)
		return productService.findOne(id);
	}

	@CrossOrigin()
	@GetMapping("/by_category")
	public List<Product> getAllProductsByCategory(
			@RequestParam int categoryId) {
		return productService.findAllByCategory(categoryId);
	}

	@CrossOrigin()
	@GetMapping("/some")
	public List<Product> getAllProductsByCategoryAndPrice() {
		System.out.println("getting a whole bunch of data");
		return productService.findAllByCategoryAndPriceRange(null, 0, 0);
	}
	
	@CrossOrigin()
	@GetMapping("/search")
	public List<Product> getAllProductsBySearch(@RequestParam String name) {
		System.out.println("getting a whole bunch of data");
		return productService.findAllBySearch(name);
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		productService.save(product);
		return product;
	}
}
