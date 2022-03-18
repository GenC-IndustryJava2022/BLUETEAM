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

import com.cognizant.academy.blueteam.models.ActiveProducts;
import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.models.Product;
import com.cognizant.academy.blueteam.services.ActiveProductsService;

@RestController
@RequestMapping("activeproducts")
public class ActiveProductsController {
	@Autowired
	private ActiveProductsService activeProductsService;

	public ActiveProductsController(ActiveProductsService activeProductsService) {
		super();
		this.activeProductsService = activeProductsService;
	}

	public ActiveProductsService getActiveProductsService() {
		return activeProductsService;
	}

	public void setActiveProductsService(ActiveProductsService activeProductsService) {
		this.activeProductsService = activeProductsService;
	}

	@Override
	public String toString() {
		return "ActiveProductsController [activeProductsService=" + activeProductsService + "]";
	}

	@CrossOrigin()
	@GetMapping("/all")
	public List<ActiveProducts> getAllActiveProducts() {
		System.out.println("getting a whole bunch of data");
		return activeProductsService.findAll();
	}

	@CrossOrigin()
	@GetMapping("/find")
	public Optional<ActiveProducts> getOneActiveProduct(@RequestParam int id) {
		return activeProductsService.findOne(id);
	}

	@CrossOrigin()
	@GetMapping("/by_cart")
	public List<ActiveProducts> getAllActiveProductsByCart(
			@RequestParam int cartId) {
		return activeProductsService.findAllByCart(cartId);
	}	
	
	@CrossOrigin()
	@PostMapping("/add")
	public ActiveProducts addActiveProducts(@RequestBody ActiveProducts activeProducts) {
		System.out.println("got a converted product " + activeProducts);
		activeProductsService.add(activeProducts);
		return activeProducts;
	}
}
