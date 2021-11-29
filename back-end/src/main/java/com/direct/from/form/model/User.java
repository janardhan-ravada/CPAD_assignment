package com.direct.from.form.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Email
	@Column(nullable = false)
	private String email;

	private String imageUrl;

	@Column(nullable = false)
	private Boolean emailVerified = false;

	@JsonIgnore
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	private String providerId;

	@Column(name = "user_type")
	private String userType;

	@OneToOne
	private Farmer farmer;

	@OneToOne
	private Consumer consumer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public final String getUserType() {
		return userType;
	}

	public final void setUserType(String userType) {
		this.userType = userType;
	}

	public final Farmer getFarmer() {
		return farmer;
	}

	public final void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public final Consumer getConsumer() {
		return consumer;
	}

	public final void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public User(Long id, String name, @Email String email, String imageUrl, Boolean emailVerified, String password,
			@NotNull AuthProvider provider, String providerId, String userType, Farmer farmer, Consumer consumer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.imageUrl = imageUrl;
		this.emailVerified = emailVerified;
		this.password = password;
		this.provider = provider;
		this.providerId = providerId;
		this.userType = userType;
		this.farmer = farmer;
		this.consumer = consumer;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(email).append(imageUrl).append(emailVerified)
				.append(provider).append(providerId).append(userType).append(farmer).append(consumer).hashCode();
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

		User user = (User) obj;
		return new EqualsBuilder().append(id, user.id).append(name, user.name).append(email, user.email)
				.append(imageUrl, user.imageUrl).append(emailVerified, user.emailVerified)
				.append(provider, user.provider).append(providerId, user.providerId).append(userType, user.userType)
				.append(farmer, user.farmer).append(consumer, user.consumer).isEquals();

	}
}
