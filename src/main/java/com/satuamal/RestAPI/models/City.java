package com.satuamal.RestAPI.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "city_name", nullable = false, unique = true)
	private String cityName;

	public City() {
		super();
	}

	public City(String cityName) {
		super();
		this.cityName = cityName.toLowerCase();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName.toLowerCase();
	}
}
