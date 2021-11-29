package com.direct.from.form.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order", catalog = "spring_social")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "consumer_id")
	@JsonIgnore
	private Consumer consumer;

	@OneToOne
	@JoinColumn(name = "shipping_address_id")
	private Address shippingAddress;

	@OneToOne
	@JoinColumn(name = "billing_address_id")
	private Address billingAddress;

	@Column(name = "status")
	private String status;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "is_amount_paid")
	private Boolean isAmountPaid;

	@Column(name = "total_price_with_discount")
	private Double totalPriceWithDiscount;

	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProducts = new ArrayList<>();
	
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final Consumer getConsumer() {
		return consumer;
	}

	public final void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public final Address getShippingAddress() {
		return shippingAddress;
	}

	public final void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public final Address getBillingAddress() {
		return billingAddress;
	}

	public final void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
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

	public final String getPaymentMethod() {
		return paymentMethod;
	}

	public final void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public final Boolean getIsAmountPaid() {
		return isAmountPaid;
	}

	public final void setIsAmountPaid(Boolean isAmountPaid) {
		this.isAmountPaid = isAmountPaid;
	}

	public final List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public final void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public final Double getTotalPriceWithDiscount() {
		return totalPriceWithDiscount;
	}

	public final void setTotalPriceWithDiscount(Double totalPriceWithDiscount) {
		this.totalPriceWithDiscount = totalPriceWithDiscount;
	}
	
	public final Calendar getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Order(Long id, Consumer consumer, Address shippingAddress, Address billingAddress, String status,
			Double totalPrice, String paymentMethod, Boolean amountPaid, List<OrderProduct> orderProducts) {
		super();
		this.id = id;
		this.consumer = consumer;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.status = status;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.isAmountPaid = amountPaid;
		this.orderProducts = orderProducts;
	}

	public Order() {
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(consumer).append(shippingAddress).append(billingAddress)
				.append(status).append(totalPrice).append(paymentMethod).append(isAmountPaid).append(orderProducts)
				.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		Order order = (Order) obj;
		return new EqualsBuilder().append(id, order.id).append(consumer, order.consumer)
				.append(shippingAddress, order.shippingAddress).append(billingAddress, order.billingAddress)
				.append(status, order.status).append(totalPrice, order.totalPrice)
				.append(paymentMethod, order.paymentMethod).append(isAmountPaid, order.isAmountPaid)
				.append(orderProducts, order.orderProducts).isEquals();

	}
}
