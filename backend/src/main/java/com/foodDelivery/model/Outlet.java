package com.foodDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outlet")
@Getter
@Setter
@NoArgsConstructor
public class Outlet {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	@Column(name = "rating")
	private Float rating;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private OutletAddress address;

	public Outlet(Float rating, Restaurant restaurant, OutletAddress address) {
		super();
		this.rating = rating;
		this.restaurant = restaurant;
		this.address = address;
	}
}
