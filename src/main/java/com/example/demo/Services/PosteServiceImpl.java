package com.example.demo.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.CandidatRepo;
import com.example.demo.Repo.PosteRepo;
import com.example.demo.entities.Poste;
import com.example.demo.entities.candidat;

@Service
@Transactional
public class PosteServiceImpl implements PosteService{
	@Autowired
	PosteRepo posteRepo;
	@Autowired
	CandidatRepo candidatRepo;
	
	public void affecterCandidat(Poste poste, List<Long> idCandidat) {
		posteRepo.save(poste);
		List<candidat> candidats =candidatRepo.findAll();
		for (candidat candidat : candidats) {
			for (Long id : idCandidat) {
				if (candidat.getId().equals(id)) {
					candidat.getPoste().add(poste);
					posteRepo.save(poste);
				}
			}
		}
	}

	@Override
	public List<candidat> listedecandidat(Long idCandidat) {
		return candidatRepo.findByPosteId(idCandidat);
	}

	



	

}
