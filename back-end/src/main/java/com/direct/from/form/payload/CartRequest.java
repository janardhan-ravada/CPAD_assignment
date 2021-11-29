package com.direct.from.form.payload;

public class CartRequest {
	private Long productId;
	private Long orderedQuantity;
	private Double packPrice;
	private Double packPriceWithDiscount;
	private Double discountOnPack;
	private String discountType;

	private Double cartPrice;
	private Double cartPriceWithDiscount;

	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final Long getOrderedQuantity() {
		return orderedQuantity;
	}

	public final void setOrderedQuantity(Long orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public final Double getPackPrice() {
		return packPrice;
	}

	public final void setPackPrice(Double packPrice) {
		this.packPrice = packPrice;
	}

	public final Double getPackPriceWithDiscount() {
		return packPriceWithDiscount;
	}

	public final void setPackPriceWithDiscount(Double packPriceWithDiscount) {
		this.packPriceWithDiscount = packPriceWithDiscount;
	}

	public final Double getDiscountOnPack() {
		return discountOnPack;
	}

	public final void setDiscountOnPack(Double discountOnPack) {
		this.discountOnPack = discountOnPack;
	}

	public final String getDiscountType() {
		return discountType;
	}

	public final void setDiscountType(String discountType) {
		this.discountType = discountType;
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
