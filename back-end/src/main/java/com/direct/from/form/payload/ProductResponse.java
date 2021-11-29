package com.direct.from.form.payload;

public class ProductResponse {
	private Long id;
	private String name;
	private String desription;
	private Long totalPacks;
	private String packUnit;
	private Double packPrice;
	private Double packQuantity;
	private Double discountOnPack;
	private String discountType;
	private FarmerResponse farmer;
	private Double packPriceWithDiscount;
	private Double totalPacksPrice;
	private Double totalPacksPriceWithDiscount;
	private String imageURL;
	private Double defaultRating;
	private Double maxRating;
	
	private Long orderedQuantity;
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

	public final String getDesription() {
		return desription;
	}

	public final void setDesription(String desription) {
		this.desription = desription;
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

	public final String getDiscountType() {
		return discountType;
	}

	public final void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public final FarmerResponse getFarmer() {
		return farmer;
	}

	public final void setFarmer(FarmerResponse farmer) {
		this.farmer = farmer;
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

	public final String getImageURL() {
		return imageURL;
	}

	public final void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public final Double getDefaultRating() {
		return defaultRating;
	}

	public final void setDefaultRating(Double defaultRating) {
		this.defaultRating = defaultRating;
	}

	public final Double getMaxRating() {
		return maxRating;
	}

	public final void setMaxRating(Double maxRating) {
		this.maxRating = maxRating;
	}

	public final Long getOrderedQuantity() {
		return orderedQuantity;
	}

	public final void setOrderedQuantity(Long orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	
	public final Long getRemainingPacks() {
		return remainingPacks;
	}

	public final void setRemainingPacks(Long remainingPacks) {
		this.remainingPacks = remainingPacks;
	}

	public ProductResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(Long id, String name, String desription, Long totalPacks, String packUnit, Double packPrice,
			Double packQuantity, Double discountOnPack, String discountType, FarmerResponse farmer,
			Double packPriceWithDiscount, Double totalPacksPrice, Double totalPacksPriceWithDiscount) {
		super();
		this.id = id;
		this.name = name;
		this.desription = desription;
		this.totalPacks = totalPacks;
		this.packUnit = packUnit;
		this.packPrice = packPrice;
		this.packQuantity = packQuantity;
		this.discountOnPack = discountOnPack;
		this.discountType = discountType;
		this.farmer = farmer;
		this.packPriceWithDiscount = packPriceWithDiscount;
		this.totalPacksPrice = totalPacksPrice;
		this.totalPacksPriceWithDiscount = totalPacksPriceWithDiscount;
	}

}
