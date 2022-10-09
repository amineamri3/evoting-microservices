package com.evoting.electionservice.Repositories;

import com.evoting.electionservice.Entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<Election,Long> {
}
