package com.cognizant.academy.blueteam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.cognizant.academy.blueteam.models.ActiveProducts;
import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.models.Product;
import com.cognizant.academy.blueteam.services.ActiveProductsService;
import com.cognizant.academy.blueteam.services.CartService;
import com.cognizant.academy.blueteam.services.ProductService;

@RestController
@RequestMapping("carts")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ActiveProductsService activeProductsService;

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

		Cart newcart = cartService.add(new Cart(0, browserInfo));
		System.out.println(newcart);
		return newcart;
	}

	@CrossOrigin()
	@GetMapping("/costs")
	public Map<Integer, Double> getTotalCosts(@RequestParam int id) {
		// returns a mapping of product ID's to summed costs
		Map<Integer, Double> results = new HashMap<Integer, Double>();
		for (ActiveProducts activeProduct : this.activeProductsService
				.findAllByCart(id)) {
			Optional<Product> product = this.productService
					.findOne(activeProduct.getProductId());
			if (product.isPresent()) {
				results.put(product.get().getProductId(),
						activeProduct.getQuantity() * product.get().getPrice());
			}
		}
		return results;
	}
}
