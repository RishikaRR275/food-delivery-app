package com.foodDelivery.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RestaurantAddress")
@Getter
@Setter
@NoArgsConstructor
public class OutletAddress extends Address {

}
