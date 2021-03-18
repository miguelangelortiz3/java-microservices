package com.sae.qs.web.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.sae.qs.web.model.Customer;

@ApplicationScoped 
public class CustomersRepositoryImpl implements CustomersRepository {
	
	private List<Customer> inMemoryRepo = new ArrayList<Customer>();
	
	public CustomersRepositoryImpl() {
		inMemoryRepo.add(new Customer(1L, "John Winston Lennon", "251 Menlove Avenue", "00000001"));
		inMemoryRepo.add(new Customer(2L, "Sir James Paul McCartney", "Waterfall Estate, Peasmarsh Rye TN31 6XN UK", "00000002"));
		inMemoryRepo.add(new Customer(3L, "George Harrison", "16 Church St, Henley-on-Thames RG9 1SE UK", "00000003"));
		inMemoryRepo.add(new Customer(4L, "Sir Richard Starkey", "1541 Ocean Avenue Suite 200 Santa Monica CA USA", "00000004"));
	}
	
	@Override
	public List<Customer> listCustomers() {
		return this.inMemoryRepo;
	}

	@Override
	public Customer findCustomerById(long id) {
		return inMemoryRepo.stream().filter(customer -> customer.getId() == id).collect(Collectors.reducing((a, b) -> null)).orElse(null);
	}

	@Override
	public void saveCustomer(Customer customer) {
		this.removeCustomerById(customer.getId());
		this.inMemoryRepo.add(customer);
	}

	@Override
	public void removeCustomerById(long id) {
		inMemoryRepo.removeIf(customer -> customer.getId() == id);
	}
}
