package com.direct.from.form.payload;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
	private List<ProductResponse> products = new ArrayList<>();
	private Double cartPrice;
	private Double cartPriceWithDiscount;
	private Long cartId;

	public final List<ProductResponse> getProducts() {
		return products;
	}

	public final void setProducts(List<ProductResponse> products) {
		this.products = products;
	}

	public final Long getCartId() {
		return cartId;
	}

	public final void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public final Double getCartPrice() {
		return cartPrice;
	}

	public final void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public final Double getCartPriceWithDiscount() {
		return cartPriceWithDiscount;
	}

	public final void setCartPriceWithDiscount(Double cartPriceWithDiscount) {
		this.cartPriceWithDiscount = cartPriceWithDiscount;
	}
}
