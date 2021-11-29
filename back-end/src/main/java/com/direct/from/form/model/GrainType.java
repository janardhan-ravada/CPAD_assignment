package com.direct.from.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "grain_type", catalog = "spring_social")
public class GrainType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

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

	public GrainType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public GrainType() {
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).hashCode();
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

		GrainType grainType = (GrainType) obj;
		return new EqualsBuilder().append(id, grainType.id).append(name, grainType.name).isEquals();

	}
}
