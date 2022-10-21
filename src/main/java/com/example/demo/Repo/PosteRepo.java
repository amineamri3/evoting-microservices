package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Poste;

public interface PosteRepo extends JpaRepository<Poste, Long> {

}
