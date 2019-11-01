package com.foodDelivery.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Address {
	@Id
	@GeneratedValue
	protected Integer id;
	@Column(name="streetNo")
	protected Integer streetNo;
	@Column(name="locality")
	protected String locality;
	@Column(name = "pinCode")
	protected Integer pinCode;
	@Column(name = "city")
	protected String city;

}
