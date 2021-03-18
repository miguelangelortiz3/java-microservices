package com.sae.vs.web;

import com.sae.vs.model.Customer;
import com.sae.vs.repository.CustomersRepository;
import com.sae.vs.repository.CustomersRepositoryImpl;

import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class CustomersRouting {
	
	private static final int STATUS_CODE_OK = 200;
	private static final int STATUS_CODE_CREATED = 201;
	private static final int STATUS_CODE_NO_CONTENT = 204;
	private static final String JSON_MIME_TYPE = "application/json; charset=utf-8";
	private static final String PATH_PARAM_CUSTOMER_ID = "customerId";
	
	private static CustomersRouting instance;
	private CustomersRepository customersRepository = CustomersRepositoryImpl.getInstance();
	
	private CustomersRouting() {
	}
	
	public static CustomersRouting getInstance() {
        if (instance == null) {
            instance = new CustomersRouting();
        }
        return instance;
    }
	
	public void listCustomers(RoutingContext rc) {
		rc.response()
			.setStatusCode(STATUS_CODE_OK)
			.putHeader(HttpHeaders.CONTENT_TYPE, JSON_MIME_TYPE)
			.end(Json.encodePrettily(customersRepository.listCustomers()));
	}

	public void getCustomer(RoutingContext rc) {
		long customerId = Long.parseLong(rc.pathParam(PATH_PARAM_CUSTOMER_ID));
		
		rc.response()
			.setStatusCode(STATUS_CODE_OK)
			.putHeader(HttpHeaders.CONTENT_TYPE, JSON_MIME_TYPE)
			.end(Json.encodePrettily(customersRepository.findCustomerById(customerId)));
	}

	public void saveCustomer(RoutingContext rc) {
		Customer customer = rc.getBodyAsJson().mapTo(Customer.class);
		customersRepository.saveCustomer(customer);
		
		rc.response()
			.setStatusCode(STATUS_CODE_CREATED)
			.putHeader(HttpHeaders.CONTENT_TYPE, JSON_MIME_TYPE)
			.end();
	}

	public void deleteCustomer(RoutingContext rc) {
		long customerId = Long.parseLong(rc.pathParam(PATH_PARAM_CUSTOMER_ID));
		
		customersRepository.removeCustomerById(customerId);
		
		rc.response()
			.setStatusCode(STATUS_CODE_NO_CONTENT)
			.putHeader(HttpHeaders.CONTENT_TYPE, JSON_MIME_TYPE)
			.end();
	}
}
