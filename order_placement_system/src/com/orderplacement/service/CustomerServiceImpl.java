package com.orderplacement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderplacement.dao.CustomerDAO;
import com.orderplacement.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	// injecting the dao 
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public List<Customer> findCustomers(String searchQuery) {
		return customerDAO.findCustomers(searchQuery);
	}	

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer.getId());		
	}


	
	

}
