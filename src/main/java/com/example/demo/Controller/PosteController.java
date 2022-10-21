package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.PosteRepo;
import com.example.demo.entities.Poste;

@RestController
public class PosteController {
	private PosteRepo posteRepo;
	public PosteController(PosteRepo posteRepo){
		this.posteRepo = posteRepo;
	}
	@GetMapping(path="/postes")
	public List<Poste> listPostes(){
		return posteRepo.findAll();
	}
	@PostMapping(path="/poste")
	public Poste save(@RequestBody Poste poste){
		
		return posteRepo.save(poste);
		}
	@PutMapping(path="/poste/{id}")
	public Poste update(@PathVariable Long id,@RequestBody Poste poste){
		poste.setId(id);
		return posteRepo.save(poste);
	}
	@DeleteMapping(path="/poste/{id}")
	public void delete(@PathVariable long id){
		posteRepo.deleteById(id);
	}
}
