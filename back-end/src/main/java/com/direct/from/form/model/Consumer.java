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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "consumer", catalog = "spring_social")
public class Consumer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;

	@OneToMany
	@JoinColumn(name = "consumer_id")
	private List<Address> addresses = new ArrayList<>();

	@OneToMany(mappedBy = "consumer")
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
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

	public final List<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public final List<Order> getOrders() {
		return orders;
	}

	public final void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public Consumer() {
	}

	public Consumer(Long id, String name, String gender, Calendar dateOfBirth, List<Address> addresses,
			List<Order> orders, User user) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.addresses = addresses;
		this.orders = orders;
		this.user = user;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(gender).append(dateOfBirth).append(addresses)
				.append(orders).append(user).hashCode();
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

		Consumer consumer = (Consumer) obj;
		return new EqualsBuilder().append(id, consumer.id).append(name, consumer.name).append(gender, consumer.gender)
				.append(dateOfBirth, consumer.dateOfBirth).append(addresses, consumer.addresses)
				.append(orders, consumer.orders).append(user, consumer.user).isEquals();

	}

}
