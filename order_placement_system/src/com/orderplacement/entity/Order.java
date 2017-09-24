package com.orderplacement.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="services", joinColumns = @JoinColumn(name="customer_id"))
	@Column(name="services")
	private List<String> services; 

}
