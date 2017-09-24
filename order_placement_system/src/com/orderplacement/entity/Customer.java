package com.orderplacement.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="addr_from")
	private String addr_from;
	
	@Column(name="addr_to")
	private String addr_to;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="services", joinColumns = @JoinColumn(name="customer_id"))
	@Column(name="services")
	private List<String> services; 
	
	@Column(name="note")
	private String note;
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr_from() {
		return addr_from;
	}

	public void setAddr_from(String addr_from) {
		this.addr_from = addr_from;
	}

	public String getAddr_to() {
		return addr_to;
	}

	public void setAddr_to(String addr_to) {
		this.addr_to = addr_to;
	}
	
	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", addr_from="
				+ addr_from + ", addr_to=" + addr_to + ", services=" + services + ", note=" + note + "]";
	}


	
}
