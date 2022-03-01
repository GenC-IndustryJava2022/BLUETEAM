package com.cognizant.academy.blueteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class OnlineStoreDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreDbApplication.class, args);
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		JdbcCategoryDAO C= (JdbcCategoryDAO) context.getBean("CategoryDAO");
		JdbcProductDAO P= (JdbcProductDAO) context.getBean("ProductDAO");
		JdbcProductDAO Car= (JdbcProductDAO) context.getBean("CartDAO");
		
		
		
	}

}
