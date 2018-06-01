package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @author : VipinK
* @since : 02-Oct-2017
*/

//@Profile(value = {"dev"})
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage( "com.blog.controller" ))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
                "Blog Service API documentation",
                "This document contains all the api endpoints created in blog service with input formats",
                "v1.0",
                "Terms of service",
                new Contact("Admin", "https://www.vipink.com/", "vipink@gmail.com"),
               "License Version 2.0",
               "https://www.vipink.com/LICENSE-2.0");
	}
	
	
	

}
