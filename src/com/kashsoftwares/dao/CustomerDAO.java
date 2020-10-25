package com.kashsoftwares.dao;

import java.util.List;

import com.kashsoftwares.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
