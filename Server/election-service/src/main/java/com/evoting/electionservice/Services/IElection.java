package com.evoting.electionservice.Services;

import com.evoting.electionservice.Entities.Election;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IElection {

    List<Election> retrieveAllElections();

    Election addElection(Election election);

    void deleteElection(Long id);

    void deleteAllElections();
    Election updateElection(Election election);

    Election retrieveElection(Long id);

    Boolean checkIfExist(Long id);

    Page<Election> getElectionsPagedAndSorted(int offset, int pageSize, String field);

    Page<Election> getElectionsPaged(Pageable pageable);
}
