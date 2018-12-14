package com.qa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.qa.gateway.constants.Constants;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin(Constants.ALL);
	    config.addAllowedHeader(Constants.ALL);
	    config.addAllowedMethod(Constants.GET);
	    config.addAllowedMethod(Constants.PUT);
	    config.addAllowedMethod(Constants.POST);
	    config.addAllowedMethod(Constants.DELETE);
	    source.registerCorsConfiguration(Constants.ALL_DIRS, config);
	    return new CorsFilter(source);
	}
}
