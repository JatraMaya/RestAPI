package com.satuamal.RestAPI.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User {


	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid4")
	private UUID id;

	@JsonIgnoreProperties(value = {"id", "hibernateLazyInitializer"})
	@JoinColumn(name = "city_id")
	@OneToOne(targetEntity = City.class, fetch = FetchType.LAZY)
	private City city;

	@Column(name = "name")
	private String name;

	@Column(name = "email", unique = true)
	private String email;

	@JsonIgnore
	@Column(name = "password")
	private String password;

	@Column(name = "alias")
	private String alias;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "role", columnDefinition = "varchar default 'VOLUNTEER'")
	@Enumerated(EnumType.STRING)
	private Role role = Role.VOLUNTEER;

	@Column(name = "status", columnDefinition = "varchar default 'ACTIVE'")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;

	public User() {
		super();
	}

	public User(City city, String name, String email, String password, String alias, String phoneNumber, Role role,
			Status status) {
		super();
		this.city = city;
		this.name = name;
		this.email = email;
		this.password = password;
		this.alias = alias;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.status = status;
	}

	public enum Role {
		DONOR, VOLUNTEER, ADMIN
	}
	
	public enum Status {
		NON_ACTIVE, ACTIVE
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

}
