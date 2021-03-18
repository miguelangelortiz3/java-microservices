package com.sae.sbs.repository;

import java.util.List;

import com.sae.sbs.model.Customer;

public interface CustomersRepository {
	List<Customer> listCustomers();
	Customer findCustomerById(long id);
	void saveCustomer(Customer customer);
	void removeCustomerById(long id);
}
