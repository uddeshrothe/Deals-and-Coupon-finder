package com.couponsservice;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.xmlpull.v1.XmlPullParserException;

import io.swagger.models.Model;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CSApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.couponsservice.controller"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Coupon Service",
				"API for fetching Coupons",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Uddesh Rothe", "https://uddeshrothe.github.io/Resume/", "uddesh.rothe1@gmail.com"),
				"API license",
				"https://uddeshrothe.github.io/Resume/",
				Collections.emptyList());
	}

}
