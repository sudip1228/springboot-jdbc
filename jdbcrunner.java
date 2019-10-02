package com.example.demo;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import jdbc.person;
import jdbc.personjdbcdao;

@SpringBootApplication
@ComponentScan("jdbc")
public class jdbcrunner implements CommandLineRunner {
	private Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	personjdbcdao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(jdbcrunner.class, args);

	}

	public void run(String... args) throws Exception {
		//dao.findall();
		log.info("all users->{}",dao.findall());
		log.info("single users->{}",dao.findbyid(1001));
		log.info("inserting 1004->{}",dao.insert(new person(1004,"tara","berlin",new Date())));
		log.info("inserting 1005->{}",dao.insert(new person(1005,"sachin","india",new Date())));

		log.info("updating 1003->{}",dao.update(new person(1003,"rabin","nyc",new Date())));

	//	log.info("delete users->{}",dao.deletebyid(1002));
	//	System.out.println("deleted "+ dao.deletebyid(1002));
		
	}
	
		
	
	

}
