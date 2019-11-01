package com.foodDelivery.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RestaurantAddress")
@Getter
@Setter
@NoArgsConstructor
public class OutletAddress extends Address {
    public OutletAddress(Integer streetNo,String locality,Integer pinCode,String city) {
        this.city=city;
        this.locality=locality;
        this.pinCode=pinCode;
        this.streetNo=streetNo;
    }
}
