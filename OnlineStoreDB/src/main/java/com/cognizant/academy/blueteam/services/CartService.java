package com.cognizant.academy.blueteam.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.repositories.CartDAO;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public CartRepository() {
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
	
	public Category add(Cart cart) {
		return cartRepository.save(cart);
	}
}
