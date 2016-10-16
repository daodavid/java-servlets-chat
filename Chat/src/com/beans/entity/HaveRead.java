package com.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="haveread")

public class HaveRead {
	@Id
	@Column(name="id")
      int id;
	public HaveRead() {
		super();
	}
	@Column(name="cheked")
	String varchar;
	public HaveRead(int check_id) {
		id=check_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVarchar() {
		return varchar;
	}
	public void setVarchar(String varchar) {
		this.varchar = varchar;
	}
	
  
}
