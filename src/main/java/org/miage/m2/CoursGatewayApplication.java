package org.miage.m2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
public class CoursGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursGatewayApplication.class, args);
	}
}
