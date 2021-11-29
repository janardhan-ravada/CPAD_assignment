package com.direct.from.form.model;

import java.util.ArrayList;
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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product", catalog = "spring_social")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "total_packs")
	private Long totalPacks;

	@Column(name = "pack_unit")
	private String packUnit;

	@Column(name = "pack_price")
	private Double packPrice;

	@Column(name = "pack_quantity")
	private Double packQuantity;

	@Column(name = "discount_on_pack")
	private Double discountOnPack;

	@Column(name = "pack_price_with_disc")
	private Double packPriceWithDiscount;

	@Column(name = "total_packs_price")
	private Double totalPacksPrice;

	@Column(name = "total_packs_price_with_disc")
	private Double totalPacksPriceWithDiscount;

	@OneToOne
	@JoinColumn(name = "grain_type_id")
	private GrainType grainType;

	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<OrderProduct> orderProducts = new ArrayList<>();

	@Column(name = "imageurl")
	private String imageURL;

	@Column(name = "remaining_packs")
	private Long remainingPacks;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

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

	public final GrainType getGrainType() {
		return grainType;
	}

	public final void setGrainType(GrainType grainType) {
		this.grainType = grainType;
	}

	public final Farmer getFarmer() {
		return farmer;
	}

	public final void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public final List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public final void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public final String getImageURL() {
		return imageURL;
	}

	public final void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	
	public final Long getRemainingPacks() {
		return remainingPacks;
	}

	public final void setRemainingPacks(Long remainingPacks) {
		this.remainingPacks = remainingPacks;
	}

	public Product() {

	}

	public Product(Long id, String name, String description, Long totalPacks, String packUnit, Double packPrice,
			Double packQuantity, Double discountOnPack, Double packPriceWithDiscount, Double totalPacksPrice,
			Double totalPacksPriceWithDiscount, GrainType grainType, Farmer farmer, List<OrderProduct> orderProducts,
			String imageURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.totalPacks = totalPacks;
		this.packUnit = packUnit;
		this.packPrice = packPrice;
		this.packQuantity = packQuantity;
		this.discountOnPack = discountOnPack;
		this.packPriceWithDiscount = packPriceWithDiscount;
		this.totalPacksPrice = totalPacksPrice;
		this.totalPacksPriceWithDiscount = totalPacksPriceWithDiscount;
		this.grainType = grainType;
		this.farmer = farmer;
		this.orderProducts = orderProducts;
		this.imageURL = imageURL;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(description).append(totalPacks).append(packUnit)
				.append(packPrice).append(packQuantity).append(discountOnPack).append(packPriceWithDiscount)
				.append(totalPacksPrice).append(totalPacksPriceWithDiscount).append(grainType).append(farmer)
				.append(orderProducts).hashCode();
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

		Product product = (Product) obj;
		return new EqualsBuilder().append(id, product.id).append(name, product.name)
				.append(description, product.description).append(totalPacks, product.totalPacks)
				.append(packUnit, product.packUnit).append(packPrice, product.packPrice)
				.append(packQuantity, product.packQuantity).append(discountOnPack, product.discountOnPack)
				.append(packPriceWithDiscount, product.packPriceWithDiscount)
				.append(totalPacksPrice, product.totalPacksPrice)
				.append(totalPacksPriceWithDiscount, product.totalPacksPriceWithDiscount)
				.append(grainType, product.grainType).append(farmer, product.farmer)
				.append(orderProducts, product.orderProducts).isEquals();

	}
}
