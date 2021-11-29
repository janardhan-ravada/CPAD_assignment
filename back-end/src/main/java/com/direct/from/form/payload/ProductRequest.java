package com.direct.from.form.payload;

public class ProductRequest {

	private String name;

	private String description;

	private Long totalPacks;

	private String packUnit;

	private Double packPrice;

	private Double packQuantity;

	private Double discountOnPack;

	private Double packPriceWithDiscount;

	private Double totalPacksPrice;

	private Double totalPacksPriceWithDiscount;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final Long getTotalPacks() {
		return totalPacks;
	}

	public final void setTotalPacks(Long totalPacks) {
		this.totalPacks = totalPacks;
	}

	public final String getPackUnit() {
		return packUnit;
	}

	public final void setPackUnit(String packUnit) {
		this.packUnit = packUnit;
	}

	public final Double getPackPrice() {
		return packPrice;
	}

	public final void setPackPrice(Double packPrice) {
		this.packPrice = packPrice;
	}

	public final Double getPackQuantity() {
		return packQuantity;
	}

	public final void setPackQuantity(Double packQuantity) {
		this.packQuantity = packQuantity;
	}

	public final Double getDiscountOnPack() {
		return discountOnPack;
	}

	public final void setDiscountOnPack(Double discountOnPack) {
		this.discountOnPack = discountOnPack;
	}

	public final Double getPackPriceWithDiscount() {
		return packPriceWithDiscount;
	}

	public final void setPackPriceWithDiscount(Double packPriceWithDiscount) {
		this.packPriceWithDiscount = packPriceWithDiscount;
	}

	public final Double getTotalPacksPrice() {
		return totalPacksPrice;
	}

	public final void setTotalPacksPrice(Double totalPacksPrice) {
		this.totalPacksPrice = totalPacksPrice;
	}

	public final Double getTotalPacksPriceWithDiscount() {
		return totalPacksPriceWithDiscount;
	}

	public final void setTotalPacksPriceWithDiscount(Double totalPacksPriceWithDiscount) {
		this.totalPacksPriceWithDiscount = totalPacksPriceWithDiscount;
	}

}
