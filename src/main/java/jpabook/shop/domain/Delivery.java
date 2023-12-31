package jpabook.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue()
    @Column(name = "DELIVERY_ID")
    private Long id;
    private String city;
    private String street;
    private String status;

}
