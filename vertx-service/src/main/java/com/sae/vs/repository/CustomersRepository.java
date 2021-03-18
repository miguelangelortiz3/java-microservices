package com.sae.vs.repository;

import java.util.List;

import com.sae.vs.model.Customer;

public interface CustomersRepository {
	List<Customer> listCustomers();
	Customer findCustomerById(long id);
	void saveCustomer(Customer customer);
	void removeCustomerById(long id);
}
