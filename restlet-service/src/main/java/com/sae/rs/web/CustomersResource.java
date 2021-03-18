package com.sae.rs.web;

import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.sae.rs.model.Customer;
import com.sae.rs.repository.CustomersRepository;
import com.sae.rs.repository.CustomersRepositoryImpl;

public class CustomersResource extends ServerResource {
	private static final String EMPTY_STRING = "";
	private static final String PATH_PARAM_CUSTOMER_ID = "customer-id";
	
	private CustomersRepository customersRepository = CustomersRepositoryImpl.getInstance();
	private Gson gson = new Gson();
	
	@Get
	public Representation getOrListCustomers() {
		String customerId = getAttribute(PATH_PARAM_CUSTOMER_ID);
		String result = "";
		
		if(customerId == null || EMPTY_STRING.equals(customerId)) {
			result = gson.toJson(customersRepository.listCustomers());
		} else {
			long customerIdLong = Long.parseLong(customerId);
			result = gson.toJson(customersRepository.findCustomerById(customerIdLong));
		}
		
		return new StringRepresentation(result, MediaType.APPLICATION_JSON);
	}

	@Post
	public void saveCustomer(Customer customer) {
		customersRepository.saveCustomer(customer);
		getResponse().setStatus(Status.SUCCESS_CREATED);
	}
	
	@Delete
	public void deleteCustomer() {
		long customerId = Long.parseLong(getAttribute(PATH_PARAM_CUSTOMER_ID));
		customersRepository.removeCustomerById(customerId);
	}
}
