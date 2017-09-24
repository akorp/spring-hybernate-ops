package com.orderplacement.service;

import java.util.List;

import com.orderplacement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public List<Customer> findCustomers(String searchQuery);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

}
