package com.beans.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


@Entity
@Table(name = "user")
public class User implements Serializable {

	public User() {
		super();
	}

	public User(String username, String password, Town town, Gender gender) {
		super();
		this.username = username;
		this.password = password;
		this.town = town;
		this.gender = gender;
	}

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "town_id", referencedColumnName = "id")
	private Town town;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	private Gender gender;

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
