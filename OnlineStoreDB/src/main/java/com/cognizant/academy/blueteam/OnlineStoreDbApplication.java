package com.cognizant.academy.blueteam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.academy.blueteam.models.*;
import com.cognizant.academy.blueteam.repositories.*;
import com.cognizant.academy.blueteam.services.*;

@SpringBootApplication
public class OnlineStoreDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreDbApplication.class, args);
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
//		CategoryService C= (CategoryService) context.getBean("CategoryDAO");
//		JdbcProductDAO P= (JdbcProductDAO) context.getBean("ProductDAO");
//		JdbcCartDAO Car= (JdbcCartDAO) context.getBean("CartDAO");
//		JdbcActiveProductsDAO A= (JdbcActiveProductsDAO) context.getBean("ActiveProductsDAO");
//		
//		Category categoryObj= new Category(15,"new category","headerimage");
//		Product productObj=new Product(24,"AAA laptop",2500000,"image","if anything undervalued",categoryObj.getCategoryId());
//		Cart cartObj= new Cart(38,"google chrome info");
//		ActiveProducts APObj=new ActiveProducts(1,cartObj.getCartId(),productObj.getProductId(),13);
		
		//C.insert(categoryObj);
		//P.insert(productObj);
		//Car.insert(cartObj);
		//A.insert(APObj);
		
		
		//-----------
		//categoryObj.setName("other category");
		//categoryObj.setHeaderImage("updated headerImage");
		//productObj.setPrice(.23);
		//productObj.setDescription("cheap laptop");
		//cartObj.setBrowserInfo("bing");
		//APObj.setQuantity(83);
		//C.update(categoryObj);
		//P.update(productObj);
		//Car.update(cartObj);
		//A.update(APObj);
		//--------
		
		//List<Product> list= P.findAll();
		//Collections.sort(list);
		//System.out.println(list);
		
		
		//A.delete(APObj);
		//Car.delete(cartObj);
		//P.delete(productObj);
		//C.delete(categoryObj);
		
//		System.out.println(C.findAll());
//		System.out.println(P.findAll());
//		System.out.println(Car.findAll());
//		System.out.println(A.findAll());

	}

}
