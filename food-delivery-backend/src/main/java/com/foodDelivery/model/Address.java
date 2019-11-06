package com.foodDelivery.model;

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
	protected Integer streetNo;
	protected String locality;
	protected Integer pinCode;
	protected String city;
}
