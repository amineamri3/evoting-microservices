package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Poste;
import com.example.demo.entities.candidat;
@RepositoryRestResource

public interface CandidatRepo extends JpaRepository<candidat, Long>{
@RestResource(path="/byposte")
	List<candidat>findByPoste(@Param(value="poste")Poste poste);

List<candidat> findByPosteId(Long idCandidat);
	
	//@Query("select e from candidat c where c.nom like :x")
	//public List<candidat> chercher(@Param("x")String nom);
	//public List<candidat> findbyNomContains(String nom);
}
