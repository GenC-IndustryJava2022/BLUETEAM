package com.cognizant.academy.blueteam.repository;

import com.cognizant.academy.blueteam.models.Category;

public interface CategoryDAO {
	public void insert(Category C);
	public void update(Category C);
	public void delete(Category C);
}
