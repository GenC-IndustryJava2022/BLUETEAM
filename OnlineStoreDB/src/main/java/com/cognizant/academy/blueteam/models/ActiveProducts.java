package com.cognizant.academy.blueteam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVE_PRODUCTS")
public class ActiveProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACTIVE_PRODUCTS_ID")
	private int activeProductsId;
	@Column(name="CART_ID")
	private int cartId;
	@Column(name="PRODUCT_ID")
	private int productId;
	@Column(name="QUANTITY")
	private int quantity;

	public ActiveProducts() {
		super();
	}

	public ActiveProducts(int activeProductsId, int cartId, int productId, int quantity) throws NegativeQuantityException {
		super();
		if(quantity < 0) {
			throw new NegativeQuantityException();
		}
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

	public void setQuantity(int quantity) throws NegativeQuantityException {
		if(quantity < 0) {
			throw new NegativeQuantityException();
		}
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ActiveProducts [activeProductsId=" + activeProductsId + ", cartId=" + cartId + ", productId="
				+ productId + ", quantity=" + quantity + "]";
	}

}
