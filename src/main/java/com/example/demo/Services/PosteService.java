package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Poste;
import com.example.demo.entities.candidat;


public interface PosteService {


	
	public void affecterCandidat(Poste poste, List<Long> idCandidat) ;

	List<candidat> listedecandidat(Long idCandidat);

}
