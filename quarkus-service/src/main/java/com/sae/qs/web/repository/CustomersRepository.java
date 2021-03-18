package com.sae.qs.web.repository;

import java.util.List;

import com.sae.qs.web.model.Customer;

public interface CustomersRepository {
	List<Customer> listCustomers();
	Customer findCustomerById(long id);
	void saveCustomer(Customer customer);
	void removeCustomerById(long id);
}
