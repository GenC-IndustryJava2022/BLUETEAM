package com.cognizant.academy.blueteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.academy.blueteam.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//	public void insert(Category C);
//	public void update(Category C);
//	public void delete(Category C);
}
