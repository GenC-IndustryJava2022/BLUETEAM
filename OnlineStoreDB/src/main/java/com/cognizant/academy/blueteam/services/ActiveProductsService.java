package com.cognizant.academy.blueteam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.ActiveProducts;
import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.repositories.ActiveProductsRepository;

@Service
public class ActiveProductsService {

	@Autowired
	private ActiveProductsRepository activeProductsRepository;

	public ActiveProductsService(
			ActiveProductsRepository activeProductsRepository) {
		super();
		this.activeProductsRepository = activeProductsRepository;
	}


	public void setActiveProductsRepository(
		ActiveProductsRepository activeProductsRepository) {
			this.activeProductsRepository = activeProductsRepository;
		}

		public ActiveProductsRepository getActiveProductsRepository() {
			return activeProductsRepository;
		}
	@Override
	public String toString() {
		return "ActiveProductsService [activeProductsRepository="
				+ activeProductsRepository + "]";
	}

	public List<ActiveProducts> findAll() {
		return activeProductsRepository.findAll();
	}
	
	public Optional<ActiveProducts> findOne(int id) {
		return activeProductsRepository.findById(id);
	}

	public ActiveProducts add(ActiveProducts activeProducts) {
		return activeProductsRepository.save(activeProducts);
	}

}
