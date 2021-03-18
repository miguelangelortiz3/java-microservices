package com.sae.ms.web;

import java.util.List;

import javax.inject.Inject;

import com.sae.ms.model.Customer;
import com.sae.ms.repository.CustomersRepository;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

@Controller("/")
public class CustomersController {
	@Inject
	private CustomersRepository customersRepository;
	
	@Get("/customers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> listCustomers() {
		return customersRepository.listCustomers();
	}
	
	@Get("/customers/{customer-id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathVariable("customer-id") long customerId) {
		return customersRepository.findCustomerById(customerId);
	}
	
	@Post("/customers")
	public HttpResponse<String> saveCustomer(Customer customer) {
		customersRepository.saveCustomer(customer);
		return HttpResponse.<String>status(HttpStatus.CREATED);
	}
	
	@Delete("/customers/{customer-id}")
	public HttpResponse<String> deleteCustomer(@PathVariable("customer-id") long customerId) {
		customersRepository.removeCustomerById(customerId);
		return HttpResponse.<String>status(HttpStatus.NO_CONTENT);
	}
}