package com.cognizant.academy.blueteam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.blueteam.models.Cart;
import com.cognizant.academy.blueteam.models.Category;
import com.cognizant.academy.blueteam.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public String toString() {
		return "CategoryController [categoryService=" + categoryService + "]";
	}

	@CrossOrigin()
	@GetMapping("/all")
	public List<Category> getAllCategories() {
		System.out.println("getting a whole bunch of data");
		return categoryService.findAll();
	}

	@CrossOrigin()
	@GetMapping("/find")
	public Optional<Category> getOneCart(@RequestParam int id) {
		return categoryService.findOne(id);
	}
	
	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category) {
		categoryService.add(category);
		return category;
	}
}
