package com.cognizant.academy.blueteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.academy.blueteam.models.ActiveProducts;


@Repository
public interface ActiveProductsRepository extends JpaRepository<ActiveProducts, Long> {
//	public void insert(Category C);
//	public void update(Category C);
//	public void delete(Category C);
}
