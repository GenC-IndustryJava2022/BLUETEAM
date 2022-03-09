package com.cognizant.academy.blueteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.academy.blueteam.models.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer>{
	//public void insert(Cart C);
	//public void update(Cart C);
	//public void delete(Cart C);
}
