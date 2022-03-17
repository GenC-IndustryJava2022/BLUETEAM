package com.cognizant.academy.blueteam.models;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {

	@Id
	@Column(name="CART_ID")
	private int cartId;
	@Column(name="BROWSER_INFO")
	private String browserInfo;

public Cart() {
	
}
	
public Cart(int cartId, String browserInfo) {
	super();
	this.cartId = cartId;
	this.browserInfo = browserInfo;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public String getBrowserInfo() {
	return browserInfo;
}
public void setBrowserInfo(String browserInfo) {
	this.browserInfo = browserInfo;
}

@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", browserInfo=" + browserInfo + "]";
}

}
