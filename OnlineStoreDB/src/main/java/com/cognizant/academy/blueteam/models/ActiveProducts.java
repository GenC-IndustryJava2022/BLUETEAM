package com.cognizant.academy.blueteam.models;

public class ActiveProducts {
	
	private int activeProductsId;
	private int cartId;
	private int productId;
	private int quantity;
	
	public ActiveProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveProducts(int activeProductsId, int cartId, int productId, int quantity) {
		super();
		this.activeProductsId = activeProductsId;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getActiveProductsId() {
		return activeProductsId;
	}

	public void setActiveProductsId(int activeProductsId) {
		this.activeProductsId = activeProductsId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ActiveProducts [activeProductsId=" + activeProductsId + ", cartId=" + cartId + ", productId="
				+ productId + ", quantity=" + quantity + "]";
	}
	
}
