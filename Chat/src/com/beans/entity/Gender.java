package com.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gender")
public class Gender {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender() {
		super();
	}
	public Gender(String name) {
		super();
		this.name = name;
	}


}
