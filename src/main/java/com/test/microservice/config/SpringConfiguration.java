package com.test.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.test.microservice")
@PropertySource("classpath:exchangeRateService.properties")
@PropertySource("classpath:cassandra.properties")
public class SpringConfiguration {

}
