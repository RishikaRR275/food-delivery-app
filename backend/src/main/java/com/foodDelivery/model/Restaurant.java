package com.foodDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurant {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "name")
	private String name;
	@Lob
	@Column(name = "pic")
	private byte[] pic;

	//public Restaurant() {}
	public Restaurant(String name, byte[] pic) {
		super();
		this.name = name;
		this.pic = pic;
	}

}
