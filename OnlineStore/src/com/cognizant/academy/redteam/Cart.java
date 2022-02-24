package com.cognizant.academy.redteam;

import java.util.*;

public class Cart {
	
private int cartId;
private String browserInfo;
private HashMap<Product, Integer> productMap;

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
public HashMap<Product, Integer> getProductMap() {
	return productMap;
}
public void setProductMap(HashMap<Product, Integer> productMap) {
	this.productMap = productMap;
}
@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", browserInfo=" + browserInfo + "]";
}

}
