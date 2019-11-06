package com.foodDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rating")
	private Float rating;
	
	@Lob
	@Column(name = "pic")
	private byte[] pic;

	public Restaurant(String name, Float rating, byte[] pic) {
		super();
		this.name = name;
		this.rating = rating;
		this.pic = pic;
	}

}
