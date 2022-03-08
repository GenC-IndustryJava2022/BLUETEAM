package com.cognizant.academy.blueteam.repository;

import com.cognizant.academy.blueteam.models.Cart;

public interface CartDAO {
	public void insert(Cart C);
	public void update(Cart C);
	public void delete(Cart C);
}
