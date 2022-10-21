package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.CandidatRepo;
import com.example.demo.entities.candidat;
@RestController
public class CandidatController {
	private CandidatRepo candidatRepo;
	public CandidatController(CandidatRepo candidatRepo){
		this.candidatRepo = candidatRepo;
	}
	@GetMapping(path="/candidats")
	public List<candidat> listCandidats(){
		return candidatRepo.findAll();
	}
	@PostMapping(path="/candidat")
	public candidat save(@RequestBody candidat candidat){
		
		return candidatRepo.save(candidat);
		}
	@PutMapping(path="/candidat/{id}")
	public candidat update(@PathVariable Long id,@RequestBody candidat candidat){
		candidat.setId(id);
		return candidatRepo.save(candidat);
	}
	@DeleteMapping(path="/candidat/{id}")
	public void delete(@PathVariable long id){
		candidatRepo.deleteById(id);
	}
}
