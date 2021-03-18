package com.sae.vs;

import com.sae.vs.web.CustomersRouting;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MainVerticle extends AbstractVerticle {
	
	private static final int SERVER_PORT = 9093;
	
	private CustomersRouting customersRouting = CustomersRouting.getInstance();

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		Router router = Router.router(vertx);
		
		router.route().handler(BodyHandler.create());
		router.route(HttpMethod.GET, "/vertx-service/customers").handler(customersRouting::listCustomers);
		router.route(HttpMethod.GET, "/vertx-service/customers/:customerId").handler(customersRouting::getCustomer);
		router.route(HttpMethod.POST, "/vertx-service/customers").handler(customersRouting::saveCustomer);
		router.route(HttpMethod.DELETE, "/vertx-service/customers/:customerId").handler(customersRouting::deleteCustomer);

		vertx.createHttpServer()
				.requestHandler(router)
				.listen(SERVER_PORT)
				.onSuccess(server -> System.out.printf("HTTP server started on %d \n", server.actualPort()));
	}
}
