package com.direct.from.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_product", catalog = "spring_social")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

	@Column(name = "ordered_quantity")
	private Long orderedQuantity;

	@Column(name = "applied_discount")
	private Double appliedDiscount;

	@Column(name = "applied_discount_type")
	private String appliedDiscountType;

	@Column(name = "pack_price_with_discount")
	private Double packPriceWithDiscount;

	@Column(name = "pack_price")
	private Double packetPrice;

	@OneToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final Order getOrder() {
		return order;
	}

	public final void setOrder(Order order) {
		this.order = order;
	}

	public final Product getProduct() {
		return product;
	}

	public final void setProduct(Product product) {
		this.product = product;
	}

	public final Long getOrderedQuantity() {
		return orderedQuantity;
	}

	public final void setOrderedQuantity(Long orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public final Double getAppliedDiscount() {
		return appliedDiscount;
	}

	public final void setAppliedDiscount(Double appliedDiscount) {
		this.appliedDiscount = appliedDiscount;
	}

	public final String getAppliedDiscountType() {
		return appliedDiscountType;
	}

	public final void setAppliedDiscountType(String appliedDiscountType) {
		this.appliedDiscountType = appliedDiscountType;
	}

	public final Double getPackPriceWithDiscount() {
		return packPriceWithDiscount;
	}

	public final void setPackPriceWithDiscount(Double packPriceWithDiscount) {
		this.packPriceWithDiscount = packPriceWithDiscount;
	}

	public final Double getPacketPrice() {
		return packetPrice;
	}

	public final void setPacketPrice(Double packetPrice) {
		this.packetPrice = packetPrice;
	}

	public final Farmer getFarmer() {
		return farmer;
	}

	public final void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public OrderProduct(Long id, Order order, Product product, Long orderedQuantity, Double appliedDiscount,
			String appliedDiscountType, Double packPriceWithDiscount, Double packetPrice, Farmer farmer) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.orderedQuantity = orderedQuantity;
		this.appliedDiscount = appliedDiscount;
		this.appliedDiscountType = appliedDiscountType;
		this.packPriceWithDiscount = packPriceWithDiscount;
		this.packetPrice = packetPrice;
		this.farmer = farmer;
	}

	public OrderProduct() {
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(order).append(product).append(orderedQuantity)
				.append(appliedDiscount).append(appliedDiscountType).append(packPriceWithDiscount).append(farmer)
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

		OrderProduct orderProduct = (OrderProduct) obj;
		return new EqualsBuilder().append(id, orderProduct.id).append(order, orderProduct.order)
				.append(product, orderProduct.product).append(orderedQuantity, orderProduct.orderedQuantity)
				.append(appliedDiscount, orderProduct.appliedDiscount)
				.append(appliedDiscountType, orderProduct.appliedDiscountType)
				.append(packPriceWithDiscount, orderProduct.packPriceWithDiscount).append(farmer, orderProduct.farmer)
				.isEquals();

	}

}
