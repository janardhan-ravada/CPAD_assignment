package com.direct.from.form.payload;

public class OrderRequest {
	private Long addressId;
	private Boolean isAmountPaid;
	private String status;
	private Double totalPrice;
	private Double totalPriceWithDiscount;

	public final Long getAddressId() {
		return addressId;
	}

	public final void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public final Boolean getIsAmountPaid() {
		return isAmountPaid;
	}

	public final void setIsAmountPaid(Boolean isAmountPaid) {
		this.isAmountPaid = isAmountPaid;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
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
}
