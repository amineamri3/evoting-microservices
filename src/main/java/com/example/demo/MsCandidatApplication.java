package com.example.demo;

import java.util.Date;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Repo.CandidatRepo;
import com.example.demo.Repo.PosteRepo;
import com.example.demo.entities.Poste;
import com.example.demo.entities.candidat;

@SpringBootApplication
public class MsCandidatApplication implements CommandLineRunner{

	@Autowired
	private CandidatRepo candidatRepo;
	@Autowired
	private PosteRepo posteRepo;
	public static void main(String[] args) {
		SpringApplication.run(MsCandidatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
 ///TODO Auto-generated method stub
//repositoryRestConfiguration.expose(Poste.class,candidat.class);
//repositoryRestConfiguration.getCorsRegistry()
//		.addMapping("/**")
//		.allowedOrigins("*")
//		.allowedHeaders("*")
//		.allowedMethods("OPTIONS","HEAD","GET","Put","POST","DELETE","PATCH");
//		Poste p1=posteRepo.save(new Poste(null,"président",null));
//		Poste p2=posteRepo.save(new Poste(null,"président",null));
//		Poste p3=posteRepo.save(new Poste(null,"président",null));
//		candidatRepo.save(new candidat(null,"Donald","Trump",new Date(),"hello.png",p1));
//		candidatRepo.save(new candidat(null,"Joe ","Biden",new Date(),"hello.png",p2));
//		candidatRepo.save(new candidat(null,"Hillary ","Clinton",new Date(),"hello.png",p3));

	}

}
