package com.sae.rs.repository;

import java.util.List;

import com.sae.rs.model.Customer;

public interface CustomersRepository {
	List<Customer> listCustomers();
	Customer findCustomerById(long id);
	void saveCustomer(Customer customer);
	void removeCustomerById(long id);
}
