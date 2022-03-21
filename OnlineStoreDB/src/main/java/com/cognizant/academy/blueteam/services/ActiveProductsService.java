package com.cognizant.academy.blueteam.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.ActiveProducts;
import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.models.Category;
import com.cognizant.academy.blueteam.models.DuplicateTableEntryException;
import com.cognizant.academy.blueteam.models.Product;
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
	
	public List<ActiveProducts> findAllByCart(int cartId){
		List<ActiveProducts> all = activeProductsRepository.findAll();
		List<ActiveProducts> returning=all.stream()
		.filter(x->x.getCartId()==cartId)
		.collect(Collectors.toList());
		return returning;
	}
	
	public List<ActiveProducts> findAllByCart(Cart cart){
		return findAllByCart(cart.getCartId());
	}

	public ActiveProducts add(ActiveProducts activeProducts) {
		List<ActiveProducts> mutualProducts = this.findAllByCart(activeProducts.getCartId());
		if(mutualProducts.stream().anyMatch(ap->ap.getProductId() == activeProducts.getProductId())) {
			throw new DuplicateTableEntryException("this product is already in the cart");
		}
		return activeProductsRepository.save(activeProducts);
	}
	
	public ActiveProducts save(ActiveProducts activeProducts) {
		System.out.println("saving an activeProduct: " + activeProducts);
		return activeProductsRepository.save(activeProducts);
	}

	public void delete(ActiveProducts activeProducts) {
		activeProductsRepository.delete(activeProducts);
	}



}
