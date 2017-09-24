package com.orderplacement.dao;

import java.util.List;

import com.orderplacement.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public List<Customer> findCustomers(String searchQuery);
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public Object deleteCustomer(int id);



}
