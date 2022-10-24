package com.evoting.inscriptionservice.Repositories;

import com.evoting.inscriptionservice.Models.ElectionSignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SignupRepo extends JpaRepository<ElectionSignup, UUID> {
    List<ElectionSignup> findByCandidateId(String id);
    List<ElectionSignup> findByElectionId(String id);

    void deleteById(UUID id);
}
