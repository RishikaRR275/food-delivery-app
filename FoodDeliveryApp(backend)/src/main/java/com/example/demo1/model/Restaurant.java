package com.example.demo1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Restaurant {
	@Id
	String name;
	Float rating;
	Integer noOfOutlets;
	@Lob
	byte[] pic;

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Integer getNoOfOutlets() {
		return noOfOutlets;
	}

	public void setNoOfOutlets(Integer noOfOutlets) {
		this.noOfOutlets = noOfOutlets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

}
