package com.example.supervisor.service;

import com.example.supervisor.service.model.Supervisor;
import com.example.supervisor.service.repository.SupervisorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args)

		;
	}


//
//	@Bean
//	public CommandLineRunner loaddata(SupervisorRepository supervisorRepository){
//		return args ->{
//			Supervisor supervisor=new Supervisor();
//			supervisor.setFirstName("Ahmed");
//			supervisor.setLastName("mhd");
//
//			supervisor.setOrganisation("lolo");
//			supervisor.setNbre(2);
//			Supervisor supervisor1=new Supervisor();
//			supervisor1.setFirstName("sd");
//			supervisor1.setLastName("ghjku");
//			supervisor1.setOrganisation("ghgkhyt");
//			supervisor1.setNbre(0);
//			supervisorRepository.save(supervisor);
//			supervisorRepository.save(supervisor1);
//
//
//		};}
}
