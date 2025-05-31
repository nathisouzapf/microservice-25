package br.edu.atitus.gateway_service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	@Bean
	RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/get")
				.filters(f -> f
						.addRequestHeader("X-USER-ID", "1234")
						.addRequestParameter("env", "dev"))
				.uri("http://httpbin.org:80"))
			.route(p -> p
					.path("/currency/*")
					.uri("lb://currency-service"))
			.route(p -> p
					.path("/products/**")
					.uri("lb://product-service"))
			.build();
	}

}
