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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "farmer", catalog = "spring_social")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "enterprise_name")
	private String enterpriseName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private Calendar dateOfBirth;

	@Column(name = "rating")
	private Double rating;

	@OneToMany
	@JoinColumn(name = "farmer_id")
	private List<Address> addresses = new ArrayList<>();

	@OneToMany(mappedBy = "farmer")
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "farmer")
	private List<OrderProduct> orders = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public final String getEnterpriseName() {
		return enterpriseName;
	}

	public final void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public final String getGender() {
		return gender;
	}

	public final void setGender(String gender) {
		this.gender = gender;
	}

	public final Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public final void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public final Double getRating() {
		return rating;
	}

	public final void setRating(Double rating) {
		this.rating = rating;
	}

	public final List<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public final List<Product> getProducts() {
		return products;
	}

	public final void setProducts(List<Product> products) {
		this.products = products;
	}

	public final List<OrderProduct> getOrders() {
		return orders;
	}

	public final void setOrders(List<OrderProduct> orders) {
		this.orders = orders;
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public Farmer(Long id, String name, String enterpriseName, String gender, Calendar dateOfBirth, Double rating,
			List<Address> addresses, List<Product> products, List<OrderProduct> orders, User user) {
		super();
		this.id = id;
		this.name = name;
		this.enterpriseName = enterpriseName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.rating = rating;
		this.addresses = addresses;
		this.products = products;
		this.orders = orders;
		this.user = user;
	}

	public Farmer() {
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(enterpriseName).append(gender).append(dateOfBirth)
				.append(rating).append(addresses).append(products).append(orders).append(user).hashCode();
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

		Farmer farmer = (Farmer) obj;
		return new EqualsBuilder().append(id, farmer.id).append(name, farmer.name)
				.append(enterpriseName, farmer.enterpriseName).append(gender, farmer.gender)
				.append(dateOfBirth, farmer.dateOfBirth).append(rating, farmer.rating)
				.append(addresses, farmer.addresses).append(products, farmer.products).append(orders, farmer.orders)
				.append(user, farmer.user).isEquals();

	}
}
