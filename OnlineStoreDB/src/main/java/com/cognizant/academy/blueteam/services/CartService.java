package com.cognizant.academy.blueteam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.repositories.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		super();
		this.cartRepository=cartRepository;
	}

	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository=cartRepository;
	}
	public CartRepository getCartRepository() {
		return cartRepository;
	}
	@Override
	public String toString() {
		return "CartService [cartRepository=" + cartRepository
				+ "]";
	}

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	public Cart add(Cart cart) {
		return cartRepository.save(cart);
	}
}
