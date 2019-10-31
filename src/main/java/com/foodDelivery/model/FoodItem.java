package com.foodDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foodItem")
@Getter
@Setter
@NoArgsConstructor
public class FoodItem {
	@GeneratedValue
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Integer price;
	@Column(name = "category")
	private String category;
	@Lob
	@Column(name = "pic")
	private byte[] pic;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "outlet_id")
	Outlet outlet;

	public FoodItem(String name, Integer price, String category, Outlet outlet, byte[] pic) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.outlet = outlet;
		this.pic = pic;
	}

}
