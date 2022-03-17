package com.cognizant.academy.blueteam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.services.CartService;

@RestController
@RequestMapping("carts")
public class CartController {
	@Autowired
	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@Override
	public String toString() {
		return "CartController [cartService=" + cartService + "]";
	}

	@GetMapping("/all")
	public List<Cart> getAllCarts() {
		return cartService.findAll();
	}

	@CrossOrigin()
	@GetMapping("/find")
	public Optional<Cart> getOneCart(@RequestParam int id) {
		return cartService.findOne(id);
	}

	@CrossOrigin()
	@PostMapping("/add")
	public Cart addCart(@RequestParam String browserInfo) {
		
		Cart newcart = cartService.add(new Cart(0,browserInfo));
		System.out.println(newcart);
		return newcart;
	
	}
	
//	@DeleteMapping("/remove")
}
