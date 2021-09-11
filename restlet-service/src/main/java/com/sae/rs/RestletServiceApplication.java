package com.sae.rs;

import org.restlet.Component;
import org.restlet.data.Protocol;

import com.sae.rs.web.CustomersResource;

public class RestletServiceApplication {
	private static final int SERVER_PORT = 9094;
	
	public static void main(String[] args) throws Exception {
		Component component = new Component();
	    component.getServers().add(Protocol.HTTP, SERVER_PORT);
	    component.getDefaultHost().attach("/restlet-service/customers", CustomersResource.class);
	    component.getDefaultHost().attach("/restlet-service/customers/{customer-id}", CustomersResource.class);
	    component.start();
	}
}
