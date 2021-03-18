package com.sae.qs.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.sae.qs.web.model.Customer;
import com.sae.qs.web.repository.CustomersRepository;

@Path("/")
public class CustomersResource {
	@Inject
	private CustomersRepository customersRepository;
	
    @GET
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listCustomers() {
		return customersRepository.listCustomers();
	}
    
    @GET
    @Path("/customers/{customer-id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("customer-id") long customerId) {
    	return customersRepository.findCustomerById(customerId);
	}
	
    
	@POST
	@Path("/customers")
	public Response saveCustomer(Customer customer) {
		customersRepository.saveCustomer(customer);
		return Response.created(null).build();
	}
	
	@DELETE
	@Path("/customers/{customer-id}")
	public Response deleteCustomer(@PathParam("customer-id") long customerId) {
		customersRepository.removeCustomerById(customerId);
		return Response.noContent().build();
	}
}