package com.kashsoftwares.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kashsoftwares.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory  sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {


		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query  and get result set
		List<Customer> customerList = query.getResultList();
		
		
		// return the results
		return customerList;
	}


	@Override
	public void saveCustomer(Customer customer) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save or update the customer
		session.saveOrUpdate(customer);
		//System.out.println("success!!!");
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		// get the customer from the database with id
		Customer customer = session.get(Customer.class, theId); 
		
		return customer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
					
		// delete the customer with primary key 
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
	}
	
	
	
	


}
