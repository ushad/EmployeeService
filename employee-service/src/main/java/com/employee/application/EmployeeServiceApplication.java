package com.employee.application;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

@ComponentScan(basePackages = {"com.employee.application",
		"com.employee.controller",
		"com.employee.dao",
		"com.employee.entity",
		"com.employee.service"})
@EntityScan("com.employee.entity")
public class EmployeeServiceApplication 
{
    public static void main( String[] args )
    {
		SpringApplication.run(EmployeeServiceApplication.class, args);

    }
    
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

}
