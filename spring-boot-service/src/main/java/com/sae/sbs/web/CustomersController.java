package com.sae.sbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sae.sbs.model.Customer;
import com.sae.sbs.repository.CustomersRepository;

@RestController
public class CustomersController {
	@Autowired
	private CustomersRepository customersRepository;
	
	@GetMapping("/customers")
	public List<Customer> listCustomers() {
		return customersRepository.listCustomers();
	}
	
	@GetMapping("/customers/{customer-id}")
	public Customer getCustomer(@PathVariable("customer-id") long customerId) {
		return customersRepository.findCustomerById(customerId);
	}
	
	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCustomer(@RequestBody Customer customer) {
		customersRepository.saveCustomer(customer);
	}
	
	@DeleteMapping("/customers/{customer-id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customer-id") long customerId) {
		customersRepository.removeCustomerById(customerId);
	}
}
