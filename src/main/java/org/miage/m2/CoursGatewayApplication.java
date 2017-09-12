package org.miage.m2;

import org.miage.m2.boundary.CoursChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;

@EnableBinding(CoursChannel.class)
@IntegrationComponentScan
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
public class CoursGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursGatewayApplication.class, args);
	}
}


