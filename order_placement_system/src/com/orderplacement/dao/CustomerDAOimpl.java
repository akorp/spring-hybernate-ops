package com.orderplacement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orderplacement.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {

	
	// injecting session factory (dao <-> database)
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void saveCustomer(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}


	@Override
	public Object deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("DELETE FROM Customer WHERE id=:id_param");
		query.setParameter("id_param", id);
		query.executeUpdate();
		
		return null;
	}

	
	@Override
	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}
	
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY id DESC", Customer.class);
		query.setMaxResults(10);
		List<Customer> customers = query.getResultList();
		return customers;
	}
	

	@Override
	public List<Customer> findCustomers(String searchQuery) {
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<Customer> query = currentSession.createQuery("FROM Customer c WHERE c.name LIKE :searchQuery ORDER BY id DESC", Customer.class);
		query.setParameter("searchQuery", "%" + searchQuery + "%");
		List<Customer> customers = query.getResultList();
		
		return customers;

	}
	
	
	// debug function
/*	private void printCustomers(List<Customer> customers) {
		for (Customer c: customers) {
			System.out.println(c);
		}
	}*/

}



















