package com.example.demo1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Outlet {
	@Id
	Integer id;
	String name;
	String location;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
