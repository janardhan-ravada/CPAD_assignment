package com.direct.from.form.payload;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderResponse {
	private Long id;
	private Double totalPrice;
	private Double totalPriceWithDiscount;
	private List<ProductResponse> products = new ArrayList<>();
	private String status;
	private Calendar createdDate;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final Double getTotalPrice() {
		return totalPrice;
	}

	public final void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public final Double getTotalPriceWithDiscount() {
		return totalPriceWithDiscount;
	}

	public final void setTotalPriceWithDiscount(Double totalPriceWithDiscount) {
		this.totalPriceWithDiscount = totalPriceWithDiscount;
	}

	public final List<ProductResponse> getProducts() {
		return products;
	}

	public final void setProducts(List<ProductResponse> products) {
		this.products = products;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final Calendar getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	
}
