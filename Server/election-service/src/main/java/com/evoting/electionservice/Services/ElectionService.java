package com.evoting.electionservice.Services;

import com.evoting.electionservice.Entities.Election;
import com.evoting.electionservice.Repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService implements IElection{


    @Autowired
    private ElectionRepository electionRepository;

    @Override
    public List<Election> retrieveAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public Election retrieveElection(Long id) {
        return electionRepository.findById(id).orElse(null);
    }

    @Override
    public Election addElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public void deleteElection(Long id) {
        electionRepository.deleteById(id);
    }

    @Override
    public void deleteAllElections() {
        electionRepository.deleteAll();
    }

    @Override
    public Boolean checkIfExist(Long id) {
        return electionRepository.existsById(id);
    }

    @Override
    public Page<Election> getElectionsPagedAndSorted(int offset, int pageSize, String field) {
        return electionRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }
    @Override
    public Page<Election> getElectionsPaged(Pageable pageable) {
        return electionRepository.findAll(pageable);
    }

}
